import com.github.east196.xcode.meta.DocMetaParser
import com.github.east196.xcode.model.Three
import java.util.List
import com.github.east196.xcode.rest.Mysql2018
import com.github.east196.xcode.rest.AntDVue2018


class Args{
  String file
}

@RestController
class Dev {

    @RequestMapping("/")
    String index() {
      "Dev"
    }

    @RequestMapping("/json")
    List<Three> json(@RequestBody Args args) {
      new DocMetaParser().action(args.file)
    }

    @RequestMapping("/bc")
    String backcode(@RequestBody Three three,String type) {
      Mysql2018.gene(three, type).content
    }
	
	@RequestMapping("/fc")
    String frontcode(@RequestBody Three three,String type) {
      AntDVue2018.gene(three, type).content
    }
}
