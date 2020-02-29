package com.github.east196.xcode.bot

import java.util.Map
import java.util.Map.Entry
import java.util.Set
import org.boon.core.reflection.BeanUtils
import org.boon.core.reflection.Reflection
import org.boon.core.reflection.fields.FieldAccess
import org.boon.Sets
import com.github.east196.xcode.model.Code
import org.boon.Boon

class Merger {
	def static <T> T mergeNotNullToFirst(Class<T> destKlass, Object... srcs) {
		var T dest = Reflection::newInstance(destKlass)
		return Merger.mergeNotNullToFirstUnSafe(dest, srcs)
	}

	def static <T> T mergeNotNullToFirst(T template, Object... srcs) {
		var T dest = BeanUtils::copy(template)
		return Merger.mergeNotNullToFirstUnSafe(dest, srcs)
	}

	def private static <T> T mergeNotNullToFirstUnSafe(T dest, Object... srcs) {
		for (Object src : srcs) {
			var Set<String> ignores = Sets::set()
			var Map<String, FieldAccess> fieldMap = BeanUtils::getFieldsFromObject(src)
			for (Entry<String, FieldAccess> entry : fieldMap.entrySet()) {
				System::out.println(entry)
				if (entry.getValue().getObject(src) === null) {
					ignores.add(entry.getKey())
				}
			}
			BeanUtils::copyProperties(src, dest, ignores)
		}
		return dest
	}

	def static <T> T mergeToFirst(T template, Object... srcs) {
		var T dest = BeanUtils::copy(template)
		for (Object src : srcs) {
			BeanUtils::copyProperties(src, dest)
		}
		return dest
	}

	def static void main(String[] args) {
		var all=mergeK2K(Code, Code)
	println(all)
	}

	def static mergeK2K(Class klassDest, Class klassSrc) {
		var destFields = Reflection.getFields(klassDest)
		var srcFields = Reflection.getFields(klassSrc)
		'''
		import «klassSrc.name»;
		import «klassDest.name»;
		
		// «klassSrc.simpleName.toFirstUpper» from = new «klassSrc.simpleName.toFirstUpper»();
		// «klassDest.simpleName.toFirstUpper» to = new «klassDest.simpleName.toFirstUpper»();
		// merge«klassDest.simpleName.toFirstUpper»To«klassSrc.simpleName.toFirstUpper»(to,from);
		public static void merge«klassDest.simpleName.toFirstUpper»To«klassSrc.simpleName.toFirstUpper»(«klassSrc.simpleName.toFirstUpper» to,«klassDest.simpleName.toFirstUpper» from){
			«FOR destField : destFields»
				«FOR srcField : srcFields»
					«IF srcField.name==destField.name»
						if(isNotEmpty(from.get«srcField.name.toFirstUpper»())){
							to.set«destField.name.toFirstUpper»(from.get«srcField.name.toFirstUpper»());
						}
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
		}
		
		// «klassSrc.simpleName.toFirstUpper» from = new «klassSrc.simpleName.toFirstUpper»();
		// «klassDest.simpleName.toFirstUpper» to = copy«klassDest.simpleName.toFirstUpper»To«klassSrc.simpleName.toFirstUpper»(from);
		public static «klassDest.simpleName.toFirstUpper» copy«klassDest.simpleName.toFirstUpper»To«klassSrc.simpleName.toFirstUpper»(«klassDest.simpleName.toFirstUpper» from){
			«klassDest.simpleName.toFirstUpper» to = new «klassDest.simpleName.toFirstUpper»();
			«FOR destField : destFields»
				«FOR srcField : srcFields»
					«IF srcField.name==destField.name»
						if(isNotEmpty(from.get«srcField.name.toFirstUpper»())){
							to.set«destField.name.toFirstUpper»(from.get«srcField.name.toFirstUpper»());
						}
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			return to;
		}
		
		public static boolean isNotEmpty(Object object){
			return object != null;
		}
		'''
	}

}
