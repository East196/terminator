"""
before run it
pip install fabric
"""

from fabric.api import *

def jar():
	local("mvn install")
	
def start():
	local("spring run  --watch -cp target/xcode.jar dev.groovy -- --server.port=6666")