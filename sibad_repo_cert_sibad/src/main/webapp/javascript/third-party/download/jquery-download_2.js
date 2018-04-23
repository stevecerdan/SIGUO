/*
 * --------------------------------------------------------------------
 * jQuery-Plugin - $.download - allows for simple get/post requests for files
 * by Scott Jehl, scott@filamentgroup.com
 * http://www.filamentgroup.com
 * reference article: http://www.filamentgroup.com/lab/jquery_plugin_for_requesting_ajax_like_file_downloads/
 * Copyright (c) 2008 Filament Group, Inc
 * Dual licensed under the MIT (filamentgroup.com/examples/mit-license.txt) and GPL (filamentgroup.com/examples/gpl-license.txt) licenses.
 * --------------------------------------------------------------------
 */  
jQuery.download_2 = function(url, data, method){
//	rCRLF = /\r?\n/g;
	//url and data options required
	if( url && data ){ 
		//data can be string of parameters or array/object
		data = typeof data == 'string' ? data : jQuery.param(data);
		//split params into form inputs
		var inputs = '';
		jQuery.each(data.split('&'), function(){ 
			var pair = this.split('=');
			var value = decodeURIComponent(pair[1]);
			/** 
			 * Inicio Decode Arrays
			 */
			var pairFinal=pair[0].split('.');
			var pairDecode = decodeURIComponent(pairFinal[0]);
			var pairConcatenada="";
			if(pairFinal[1]==undefined){
				pairConcatenada=pair[0];
			}else if(pairFinal[2]==undefined){
				pairConcatenada=pairDecode+"."+decodeURIComponent(pairFinal[1]);
			}else{
				pairConcatenada=pairDecode+"."+decodeURIComponent(pairFinal[1])+"."+decodeURIComponent(pairFinal[2]);
			}
			
			/**
			 * Fin Decode Arrays
			 */
			value = value.replace(/\+/g, ' ');
			inputs+='<input type="hidden" name="'+ pairConcatenada +'" value="'+ value +'" />'; //name=pair[0] -->Original
			console.info("name: :::>" + pairConcatenada);
			
		});
		//send request
		jQuery('<form action="'+ url +'" method="'+ (method||'post') +'" accept-charset="UTF-8">'+inputs+'</form>')
		.appendTo('body').submit().remove();
	};
}; 
