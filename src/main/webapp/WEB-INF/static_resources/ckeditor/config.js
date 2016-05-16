/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */


var myToolbar =  
                   [     
//                       { name: 'document', items : [ 'Source','-','DocProps','Preview','Print','-','Templates' ]  },
                       { name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
                       { name: 'editing', items : [ 'Find','Replace','-','SelectAll','-','Scayt' ] },
                       { name: 'insert', items : [ 'Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','Iframe' ] },                           
                       { name: 'styles', items : [ 'Font','FontSize' ] },
                       { name: 'colors', items : [ 'TextColor','BGColor' ] },
                       { name: 'basicstyles', items : [ 'Bold','Italic','Strike','-','RemoveFormat' ] },
                       { name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock' ] },
                       { name: 'links', items : [ 'Link','Unlink' ] },
                       { name: 'tools', items : [ 'Maximize','-','About' ] }
                   ];

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config
	 // config.language = 'fr';
    // config.uiColor = '#AADC6E';
    config.language = 'kr';

	// The toolbar groups arrangement, optimized for two toolbar rows.
//	config.toolbarGroups = [
//		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
//		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
//		{ name: 'links' },
//		{ name: 'insert' },
//		{ name: 'forms' },
//		{ name: 'tools' },
//		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
//		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
//		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
//		{ name: 'styles' },
//		{ name: 'colors' },
//	];
	
	// Remove some buttons, provided by the standard plugins, which we don't
    // need to have in the Standard(s) toolbar.
//    config.removeButtons = 'Underline,Subscript,Superscript';
//           config.filebrowserBrowseUrl = '/ckfinder/ckfinder.html';
//        config.filebrowserImageBrowseUrl = '/ckfinder/ckfinder.html?type=Images';
//    config.filebrowserFlashBrowseUrl = '/ckfinder/ckfinder.html?type=Flash';
//    config.filebrowserUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
//    config.filebrowserImageUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
//    config.filebrowserFlashUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';

    //font config
    config.font_defaultLabel = '굴림';
    config.font_names = '굴림/굴림;Apple SD 산돌고딕 Neo/Apple SD 산돌고딕 Neo;나눔고딕/나눔고딕;나눔명조/나눔명조;Gungsuh/Gungsuh;Arial/Arial;Tahoma/Tahoma;Verdana/Verdana';

	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';
	
	config.skin = 'minimalist';
	
	config.font_defaultLabel = '돋움'; //기본글씨
	config.font_names = '굴림/Gulim;돋움/Dotum;맑은고딕/맑은고딕;';
	

	 config.filebrowserBrowseUrl = '/ckfinder/ckfinder.html';
	        config.filebrowserImageBrowseUrl = '/ckfinder/ckfinder.html?type=Images';
	        config.filebrowserFlashBrowseUrl = '/ckfinder/ckfinder.html?type=Flash';
	        config.filebrowserUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
	        config.filebrowserImageUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
	        config.filebrowserFlashUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash'; 
	
//	config.extraPlugins = 'uploadimage';
	
//	settings.addConfigValue("filebrowserImageBrowseUrl","ckfinder/ckfinder.html?type=Images");
//	settings.addConfigValue("filebrowserImageUploadUrl","/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images");
//	
};

CKEDITOR.on( 'dialogDefinition', function( ev ) {
	  var tab, field, dialogName = ev.data.name,
	      dialogDefinition = ev.data.definition;
	  

	  if( dialogName == 'image' )
	  {   
	      var infoTab = dialogDefinition.getContents( 'info' );
	       
	    txtWidth = infoTab.get( 'txtWidth' );
	    txtWidth['default'] = 550;    
	   
	  }
	});  

