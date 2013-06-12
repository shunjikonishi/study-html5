package controllers

import play.api._
import play.api.mvc._

import java.io.File;
import java.io.FilenameFilter;

object Application extends Controller {
	  
	def index = Action {
		val baseDir = new File("public/html5");
		val list = baseDir.listFiles.map(new Chapter(_)).toList;
		Ok(views.html.index(list))
	}
	
	class Chapter(dir: File) {
		def name = dir.getName;
		
		def list: List[String] = {
			dir.listFiles(new FilenameFilter() {
				def accept(file: File, name: String) = name.endsWith(".html");
			}).map (_.getName).toList;
		}
	}
}