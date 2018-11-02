if (typeof OLDSTORY_STORAGE == 'undefined') var OLDSTORY_STORAGE = {};
if (OLDSTORY_STORAGE['theme_font']=='') OLDSTORY_STORAGE['theme_font'] = 'Tinos';
OLDSTORY_STORAGE['theme_skin_color'] = '#393939';
OLDSTORY_STORAGE['theme_skin_bg_color'] = '#ffffff';
OLDSTORY_STORAGE["strings"] = {
	ajax_error: 		"Invalid server answer",
	bookmark_add: 		"Add the bookmark",
	bookmark_added:		"Current page has been successfully added to the bookmarks. You can see it in the right panel on the tab &#039;Bookmarks&#039;",
	bookmark_del: 		"Delete this bookmark",
	bookmark_title:		"Enter bookmark title",
	bookmark_exists:	"Current page already exists in the bookmarks list",
	search_error:		"Error occurs in AJAX search! Please, type your query and press search icon for the traditional search way.",
	email_confirm:		"On the e-mail address &quot;%s&quot; we sent a confirmation email. Please, open it and click on the link.",
	reviews_vote:		"Thanks for your vote! New average rating is:",
	reviews_error:		"Error saving your vote! Please, try again later.",
	error_like:			"Error saving your like! Please, try again later.",
	error_global:		"Global error text",
	name_empty:			"The name can&#039;t be empty",
	name_long:			"Too long name",
	email_empty:		"Too short (or empty) email address",
	email_long:			"Too long email address",
	email_not_valid:	"Invalid email address",
	subject_empty:		"The subject can&#039;t be empty",
	subject_long:		"Too long subject",
	text_empty:			"The message text can&#039;t be empty",
	text_long:			"Too long message text",
	send_complete:		"Send message complete!",
	send_error:			"Transmit failed!",
	login_empty:		"The Login field can&#039;t be empty",
	login_long:			"Too long login field",
	login_success:		"Login success! The page will be reloaded in 3 sec.",
	login_failed:		"Login failed!",
	password_empty:		"The password can&#039;t be empty and shorter then 4 characters",
	password_long:		"Too long password",
	password_not_equal:	"The passwords in both fields are not equal",
	registration_success:"Registration success! Please log in!",
	registration_failed:	"Registration failed!",
	geocode_error:		"Geocode was not successful for the following reason:",
	googlemap_not_avail:	"Google map API not available!",
	editor_save_success:	"Post content saved!",
	editor_save_error:	"Error saving post data!",
	editor_delete_post:	"You really want to delete the current post?",
	editor_delete_post_header:"Delete post",
	editor_delete_success:	"Post deleted!",
	editor_delete_error:	"Error deleting post!",
	editor_caption_cancel:	"Cancel",
	editor_caption_close:	"Close"
};

OLDSTORY_STORAGE['ajax_url']			 = '/';
OLDSTORY_STORAGE['ajax_nonce']		 = 'bf8fbff60e';
OLDSTORY_STORAGE['site_url']			= '/';
OLDSTORY_STORAGE['vc_edit_mode']		= false;
OLDSTORY_STORAGE['theme_font']		= 'Tinos';
OLDSTORY_STORAGE['theme_skin']			= 'oldstory';
OLDSTORY_STORAGE['theme_skin_color']		= '#393939';
OLDSTORY_STORAGE['theme_skin_bg_color']	= '#ffffff';
OLDSTORY_STORAGE['slider_height']	= 100;
OLDSTORY_STORAGE['system_message']	= {message: '',status: '',header: ''};
OLDSTORY_STORAGE['user_logged_in']	= false;
OLDSTORY_STORAGE['toc_menu']		= 'float';
OLDSTORY_STORAGE['toc_menu_home']	= true;
OLDSTORY_STORAGE['toc_menu_top']	= true;
OLDSTORY_STORAGE['menu_fixed']		= false;
OLDSTORY_STORAGE['menu_mobile']	= 1024;
OLDSTORY_STORAGE['menu_slider']     = true;
OLDSTORY_STORAGE['menu_cache']	= false;
OLDSTORY_STORAGE['demo_time']		= 0;
OLDSTORY_STORAGE['media_elements_enabled'] = true;
OLDSTORY_STORAGE['ajax_search_enabled'] 	= true;
OLDSTORY_STORAGE['ajax_search_min_length']	= 3;
OLDSTORY_STORAGE['ajax_search_delay']		= 200;
OLDSTORY_STORAGE['css_animation']      = true;
OLDSTORY_STORAGE['menu_animation_in']  = 'slideInUp';
OLDSTORY_STORAGE['menu_animation_out'] = 'fadeOutDown';
OLDSTORY_STORAGE['popup_engine']	= 'pretty';
OLDSTORY_STORAGE['email_mask']		= '^([a-zA-Z0-9_\-]+\.)*[a-zA-Z0-9_\-]+@[a-z0-9_\-]+(\.[a-z0-9_\-]+)*\.[a-z]{2,6}$';
OLDSTORY_STORAGE['contacts_maxlength']	= 1000;
OLDSTORY_STORAGE['comments_maxlength']	= 1000;
OLDSTORY_STORAGE['remember_visitors_settings']	= false;
OLDSTORY_STORAGE['admin_mode']			= false;
OLDSTORY_STORAGE['isotope_resize_delta']	= 0.3;
OLDSTORY_STORAGE['error_message_box']	= null;
OLDSTORY_STORAGE['viewmore_busy']		= false;
OLDSTORY_STORAGE['video_resize_inited']	= false;
OLDSTORY_STORAGE['top_panel_height']		= 0;


jQuery(document).ready(function() {
    "use strict";
	main_slider_init();
	esg_init();
	reviews_stars();
	pie_skills_legend_color();
	price_filter();
	woo_ship_calc();
});


/*Revolution slider*/
function main_slider_init() {
    if (jQuery("#mainslider_1").length > 0) {
    	"use strict";
		var htmlDiv = document.getElementById("rs-plugin-settings-inline-css"); 
		var htmlDivCss=".tp-caption.BigWhite,.BigWhite{color:rgba(255,255,255,1.00);font-size:90px;line-height:90px;font-weight:400;font-style:normal;font-family:Sancreek;padding:0px 0px 0px 0px;text-decoration:none;text-align:left;background-color:transparent;border-color:transparent;border-style:none;border-width:0px;border-radius:0px 0px 0px 0px;text-transform:uppercase;text-align:center}.tp-caption.MediumWhite,.MediumWhite{color:rgba(255,255,255,1.00);font-size:40px;line-height:40px;font-weight:700;font-style:normal;font-family:Tinos;padding:0px 0px 0px 0px;text-decoration:none;text-align:left;background-color:transparent;border-color:transparent;border-style:none;border-width:0px;border-radius:0px 0px 0px 0px}.tp-caption.BigWhiteLess,.BigWhiteLess{color:rgba(255,255,255,1.00);font-size:70px;line-height:70px;font-weight:400;font-style:normal;font-family:Sancreek;padding:0px 0px 0px 0px;text-decoration:none;text-align:center;background-color:transparent;border-color:transparent;border-style:none;border-width:0px;border-radius:0px 0px 0px 0px;text-transform:uppercase;text-align:center}.tp-caption.ButtonFont,.ButtonFont{color:rgba(0,0,0,1.00);font-size:18px;line-height:23px;font-weight:700;font-style:normal;font-family:Montserrat;padding:0px 0px 0px 0px;text-decoration:none;text-align:left;background-color:transparent;border-color:transparent;border-style:none;border-width:0px;border-radius:0px 0px 0px 0px;letter-spacing:2px}";
		if(htmlDiv) {
			htmlDiv.innerHTML = htmlDiv.innerHTML + htmlDivCss;
		}
		else{
			var htmlDiv = document.createElement("div");
			htmlDiv.innerHTML = "<style>" + htmlDivCss + "</style>";
			document.getElementsByTagName("head")[0].appendChild(htmlDiv.childNodes[0]);
		}

		var setREVStartSize=function(){
			try{var e=new Object,i=jQuery(window).width(),t=9999,r=0,n=0,l=0,f=0,s=0,h=0;
				e.c = jQuery('#rev_slider_1_1');
				e.gridwidth = [1240];
				e.gridheight = [920];
						
				e.sliderLayout = "fullwidth";
				e.minHeight = 300;
				if(e.responsiveLevels&&(jQuery.each(e.responsiveLevels,function(e,f){f>i&&(t=r=f,l=e),i>f&&f>r&&(r=f,n=e)}),t>r&&(l=n)),f=e.gridheight[l]||e.gridheight[0]||e.gridheight,s=e.gridwidth[l]||e.gridwidth[0]||e.gridwidth,h=i/s,h=h>1?1:h,f=Math.round(h*f),"fullscreen"==e.sliderLayout){var u=(e.c.width(),jQuery(window).height());if(void 0!=e.fullScreenOffsetContainer){var c=e.fullScreenOffsetContainer.split(",");if (c) jQuery.each(c,function(e,i){u=jQuery(i).length>0?u-jQuery(i).outerHeight(!0):u}),e.fullScreenOffset.split("%").length>1&&void 0!=e.fullScreenOffset&&e.fullScreenOffset.length>0?u-=jQuery(window).height()*parseInt(e.fullScreenOffset,0)/100:void 0!=e.fullScreenOffset&&e.fullScreenOffset.length>0&&(u-=parseInt(e.fullScreenOffset,0))}f=u}else void 0!=e.minHeight&&f<e.minHeight&&(f=e.minHeight);e.c.closest(".rev_slider_wrapper").css({height:f})
				
			}catch(d){console.log("Failure at Presize of Slider:"+d)}
		};
						
				
		setREVStartSize();
		function revslider_showDoubleJqueryError(sliderID) {
			"use strict";
			var errorMessage = "Revolution Slider Error: You have some jquery.js library include that comes after the revolution files js include.";
			errorMessage += "<br> This includes make eliminates the revolution slider libraries, and make it not work.";
			errorMessage += "<br><br> To fix it you can:<br>&nbsp;&nbsp;&nbsp; 1. In the Slider Settings -> Troubleshooting set option:  <strong><b>Put JS Includes To Body</b></strong> option to true.";
			errorMessage += "<br>&nbsp;&nbsp;&nbsp; 2. Find the double jquery.js include and remove it.";
			errorMessage = "<span style='font-size:16px;color:#BC0C06;'>" + errorMessage + "</span>";
				jQuery(sliderID).show().html(errorMessage);
		}
		
		var tpj=jQuery;
		var revapi1;
		if(tpj("#rev_slider_1_1").revolution == undefined){
			revslider_showDoubleJqueryError("#rev_slider_1_1");
		}else{
			revapi1 = tpj("#rev_slider_1_1").show().revolution({
				sliderType:"standard", 
				jsFileLocation:"js/vendor/revslider/public/assets/js/",
				sliderLayout:"fullwidth",
				dottedOverlay:"none",
				delay:9000,
				navigation: {
					keyboardNavigation:"off",
					keyboard_direction: "horizontal",
					mouseScrollNavigation:"off",
					onHoverStop:"off",
					arrows: {
						style:"",
						enable:true,
						hide_onmobile:false,
						hide_onleave:false,
						tmp:'',
						left: {
							h_align:"left",
							v_align:"center",
							h_offset:99,
							v_offset:0
						},
						right: {
							h_align:"right",
							v_align:"center",
							h_offset:99,
							v_offset:0
						}
					}
				},
				visibilityLevels:[1240,1024,778,480],
				gridwidth:1240,
				gridheight:920,
				lazyType:"none",
				minHeight:300,
				shadow:0,
				spinner:"spinner0",
				stopLoop:"off",
				stopAfterLoops:-1,
				stopAtSlide:-1,
				shuffle:"off",
				autoHeight:"off",
				disableProgressBar:"on",
				hideThumbsOnMobile:"off",
				hideSliderAtLimit:0,
				hideCaptionAtLimit:0,
				hideAllCaptionAtLilmit:0,
				debugMode:false,
				fallbacks: {
					simplifyAll:"off",
					nextSlideOnWindowFocus:"off",
					disableFocusListener:false,
				}
			});
		}
	}
	if (jQuery("#mainslider_2").length > 0) {
		"use strict";
		var htmlDiv = document.getElementById("rs-plugin-settings-inline-css"); 
		var htmlDivCss=".tp-caption.BigWhite,.BigWhite{color:rgba(255,255,255,1.00);font-size:90px;line-height:90px;font-weight:400;font-style:normal;font-family:Sancreek;padding:0px 0px 0px 0px;text-decoration:none;text-align:left;background-color:transparent;border-color:transparent;border-style:none;border-width:0px;border-radius:0px 0px 0px 0px;text-transform:uppercase;text-align:center}.tp-caption.MediumWhite,.MediumWhite{color:rgba(255,255,255,1.00);font-size:40px;line-height:40px;font-weight:700;font-style:normal;font-family:Tinos;padding:0px 0px 0px 0px;text-decoration:none;text-align:left;background-color:transparent;border-color:transparent;border-style:none;border-width:0px;border-radius:0px 0px 0px 0px}.tp-caption.BigWhiteLess,.BigWhiteLess{color:rgba(255,255,255,1.00);font-size:70px;line-height:70px;font-weight:400;font-style:normal;font-family:Sancreek;padding:0px 0px 0px 0px;text-decoration:none;text-align:center;background-color:transparent;border-color:transparent;border-style:none;border-width:0px;border-radius:0px 0px 0px 0px;text-transform:uppercase;text-align:center}";
		if(htmlDiv) {
			htmlDiv.innerHTML = htmlDiv.innerHTML + htmlDivCss;
		}
		else{
			var htmlDiv = document.createElement("div");
			htmlDiv.innerHTML = "<style>" + htmlDivCss + "</style>";
			document.getElementsByTagName("head")[0].appendChild(htmlDiv.childNodes[0]);
		}

		var setREVStartSize=function(){
			try{var e=new Object,i=jQuery(window).width(),t=9999,r=0,n=0,l=0,f=0,s=0,h=0;
				e.c = jQuery('#rev_slider_2_1');
				e.gridwidth = [1240];
				e.gridheight = [813];
						
				e.sliderLayout = "auto";
				e.minHeight = 300;
				if(e.responsiveLevels&&(jQuery.each(e.responsiveLevels,function(e,f){f>i&&(t=r=f,l=e),i>f&&f>r&&(r=f,n=e)}),t>r&&(l=n)),f=e.gridheight[l]||e.gridheight[0]||e.gridheight,s=e.gridwidth[l]||e.gridwidth[0]||e.gridwidth,h=i/s,h=h>1?1:h,f=Math.round(h*f),"fullscreen"==e.sliderLayout){var u=(e.c.width(),jQuery(window).height());if(void 0!=e.fullScreenOffsetContainer){var c=e.fullScreenOffsetContainer.split(",");if (c) jQuery.each(c,function(e,i){u=jQuery(i).length>0?u-jQuery(i).outerHeight(!0):u}),e.fullScreenOffset.split("%").length>1&&void 0!=e.fullScreenOffset&&e.fullScreenOffset.length>0?u-=jQuery(window).height()*parseInt(e.fullScreenOffset,0)/100:void 0!=e.fullScreenOffset&&e.fullScreenOffset.length>0&&(u-=parseInt(e.fullScreenOffset,0))}f=u}else void 0!=e.minHeight&&f<e.minHeight&&(f=e.minHeight);e.c.closest(".rev_slider_wrapper").css({height:f})
				
			}catch(d){console.log("Failure at Presize of Slider:"+d)}
		};
						
				
		setREVStartSize();
		function revslider_showDoubleJqueryError(sliderID) {
				"use strict";
				var errorMessage = "Revolution Slider Error: You have some jquery.js library include that comes after the revolution files js include.";
				errorMessage += "<br> This includes make eliminates the revolution slider libraries, and make it not work.";
				errorMessage += "<br><br> To fix it you can:<br>&nbsp;&nbsp;&nbsp; 1. In the Slider Settings -> Troubleshooting set option:  <strong><b>Put JS Includes To Body</b></strong> option to true.";
				errorMessage += "<br>&nbsp;&nbsp;&nbsp; 2. Find the double jquery.js include and remove it.";
				errorMessage = "<span style='font-size:16px;color:#BC0C06;'>" + errorMessage + "</span>";
					jQuery(sliderID).show().html(errorMessage);
			}
		var tpj=jQuery;
			
		var revapi2;
		if(tpj("#rev_slider_2_1").revolution == undefined){
			revslider_showDoubleJqueryError("#rev_slider_2_1");
		}else{
			revapi2 = tpj("#rev_slider_2_1").show().revolution({
				sliderType:"standard", 
				jsFileLocation:"js/vendor/revslider/public/assets/js/",
				sliderLayout:"auto",
				dottedOverlay:"none",
				delay:9000,
				navigation: {
					keyboardNavigation:"off",
					keyboard_direction: "horizontal",
					mouseScrollNavigation:"off",
					onHoverStop:"off",
					arrows: {
						style:"",
						enable:true,
						hide_onmobile:false,
						hide_onleave:false,
						tmp:'',
						left: {
							h_align:"left",
							v_align:"center",
							h_offset:30,
							v_offset:0
						},
						right: {
							h_align:"right",
							v_align:"center",
							h_offset:30,
							v_offset:0
						}
					}
				},
				visibilityLevels:[1240,1024,778,480],
				gridwidth:1240,
				gridheight:813,
				lazyType:"none",
				minHeight:300,
				shadow:0,
				spinner:"spinner0",
				stopLoop:"off",
				stopAfterLoops:-1,
				stopAtSlide:-1,
				shuffle:"off",
				autoHeight:"off",
				disableProgressBar:"on",
				hideThumbsOnMobile:"off",
				hideSliderAtLimit:0,
				hideCaptionAtLimit:0,
				hideAllCaptionAtLilmit:0,
				debugMode:false,
				fallbacks: {
					simplifyAll:"off",
					nextSlideOnWindowFocus:"off",
					disableFocusListener:false,
				}
			});
		}

	}
}

/* Essential Grid */
function esg_init() {
    
    if (jQuery("#esg-grid-4-1").length > 0) {
		"use strict";
		function eggbfc(winw,resultoption) {
			var lasttop = winw,
			lastbottom = 0,
			smallest =9999,
			largest = 0,
			samount = 0,
			lamoung = 0,
			lastamount = 0,
			resultid = 0,
			resultidb = 0,
			responsiveEntries = [
								{ width:1400,amount:5},
								{ width:1170,amount:5},
								{ width:1024,amount:5},
								{ width:960,amount:5},
								{ width:778,amount:3},
								{ width:640,amount:3},
								{ width:480,amount:2}
								];
				if (responsiveEntries!=undefined && responsiveEntries.length>0)
				jQuery.each(responsiveEntries, function(index,obj) {
					var curw = obj.width != undefined ? obj.width : 0,
						cura = obj.amount != undefined ? obj.amount : 0;
					if (smallest>curw) {
						smallest = curw;
						samount = cura;
						resultidb = index;
					}
					if (largest<curw) {
						largest = curw;
						lamount = cura;
					}
					if (curw>lastbottom && curw<=lasttop) {
						lastbottom = curw;
						lastamount = cura;
						resultid = index;
					}
				})
				if (smallest>winw) {
					lastamount = samount;
					resultid = resultidb;
				}
				var obj = new Object;
				obj.index = resultid;
				obj.column = lastamount;
				if (resultoption=="id")
					return obj;
				else
					return lastamount;
		}
		if ("cobbles"=="even") {
			var coh=0,
				container = jQuery("#esg-grid-4-1");
			var	cwidth = container.width(),
				ar = "4:4",
				gbfc = eggbfc(jQuery(window).width(),"id"),
				row = 1;
				ar = ar.split(":");
				aratio=parseInt(ar[0],0) / parseInt(ar[1],0);
				coh = cwidth / aratio;
				coh = coh/gbfc.column*row;
			var ul = container.find("ul").first();
				ul.css({display:"block",height:coh+"px"});
		}
		var essapi_4;
		essapi_4 = jQuery("#esg-grid-4-1").tpessential({
	        gridID:4,
	        layout:"cobbles",
	        forceFullWidth:"off",
	        lazyLoad:"off",
	        row:1,
	        loadMoreAjaxToken:"2a8333989a",
	        loadMoreAjaxUrl:"/",
	        loadMoreAjaxAction:"Essential_Grid_Front_request_ajax",
	        ajaxContentTarget:"ess-grid-ajax-container-",
	        ajaxScrollToOffset:"0",
	        ajaxCloseButton:"off",
	        ajaxContentSliding:"on",
	        ajaxScrollToOnLoad:"on",
	        ajaxNavButton:"off",
	        ajaxCloseType:"type1",
	        ajaxCloseInner:"false",
	        ajaxCloseStyle:"light",
	        ajaxClosePosition:"tr",
	        space:0,
	        pageAnimation:"fade",
	        paginationScrollToTop:"off",
	        spinner:"spinner0",
	        lightBoxMode:"single",
	        animSpeed:1000,
	        delayBasic:1,
	        mainhoverdelay:1,
	        filterType:"single",
	        showDropFilter:"hover",
	        filterGroupClass:"esg-fgc-4",
	        googleFonts:['Open+Sans:300,400,600,700,800','Raleway:100,200,300,400,500,600,700,800,900','Droid+Serif:400,700'],
	        aspectratio:"4:4",
	        responsiveEntries: [
							{ width:1400,amount:5},
							{ width:1170,amount:5},
							{ width:1024,amount:5},
							{ width:960,amount:5},
							{ width:778,amount:3},
							{ width:640,amount:3},
							{ width:480,amount:2}
							]
		});

		try{
			jQuery("#esg-grid-4-1 .esgbox").esgbox({
				padding : [0,0,0,0],
		      	afterLoad:function() { 
		 			if (this.element.hasClass("esgboxhtml5")) {
				   		var mp = this.element.data("mp4"),
				      	ogv = this.element.data("ogv"),
				      	webm = this.element.data("webm");
		         		this.content ='<div style="width:100%;height:100%;"><video autoplay="true" loop="" class="rowbgimage" poster="" width="100%" height="auto"><source src="'+mp+'" type="video/mp4"><source src="'+webm+'" type="video/webm"><source src="'+ogv+'" type="video/ogg"></video></div>';	
				  	 	var riint = setInterval(function() {jQuery(window).trigger("resize");},100); setTimeout(function() {clearInterval(riint);},2500);
				   	};
			 	},
				beforeShow : function () { 
					this.title = jQuery(this.element).attr('data-lgtitle');
					if (this.title) {
						this.title="";
		   				this.title =  '<div style="padding:0px 0px 0px 0px">'+this.title+'</div>';
					}
				},
				afterShow : function() {
				},
				openEffect : 'fade',
				closeEffect : 'fade',
				nextEffect : 'fade',
				prevEffect : 'fade',
				openSpeed : 'normal',
				closeSpeed : 'normal',
				nextSpeed : 'normal',
				prevSpeed : 'normal',
				helpers : {
					media : {},
				    title : {
						type:""
					}
				}
			});

 		} 
 		catch (e) {}
	}

	if (jQuery("#esg-grid-2-1").length > 0) {
		"use strict";
		function eggbfc(winw,resultoption) {
			var lasttop = winw,
			lastbottom = 0,
			smallest =9999,
			largest = 0,
			samount = 0,
			lamoung = 0,
			lastamount = 0,
			resultid = 0,
			resultidb = 0,
			responsiveEntries = [
								{ width:1400,amount:3},
								{ width:1170,amount:3},
								{ width:1024,amount:3},
								{ width:960,amount:3},
								{ width:778,amount:3},
								{ width:640,amount:3},
								{ width:480,amount:1}
								];
			if (responsiveEntries!=undefined && responsiveEntries.length>0)
				jQuery.each(responsiveEntries, function(index,obj) {
					var curw = obj.width != undefined ? obj.width : 0,
						cura = obj.amount != undefined ? obj.amount : 0;
					if (smallest>curw) {
						smallest = curw;
						samount = cura;
						resultidb = index;
					}
					if (largest<curw) {
						largest = curw;
						lamount = cura;
					}
					if (curw>lastbottom && curw<=lasttop) {
						lastbottom = curw;
						lastamount = cura;
						resultid = index;
					}
				})
				if (smallest>winw) {
					lastamount = samount;
					resultid = resultidb;
				}
				var obj = new Object;
				obj.index = resultid;
				obj.column = lastamount;
				if (resultoption=="id")
					return obj;
				else
					return lastamount;
		}
		if ("masonry"=="even") {
			var coh=0,
				container = jQuery("#esg-grid-2-1");
			var	cwidth = container.width(),
				ar = "4:3",
				gbfc = eggbfc(jQuery(window).width(),"id"),
				row = 2;
				ar = ar.split(":");
				aratio=parseInt(ar[0],0) / parseInt(ar[1],0);
				coh = cwidth / aratio;
				coh = coh/gbfc.column*row;
			var ul = container.find("ul").first();
				ul.css({display:"block",height:coh+"px"});
		}
		var essapi_2;
		essapi_2 = jQuery("#esg-grid-2-1").tpessential({
	        gridID:2,
	        layout:"masonry",
	        forceFullWidth:"off",
	        lazyLoad:"off",
	        gridID:"2",
	        loadMoreType:"button",
	        loadMoreAmount:3,
	        loadMoreTxt:"View More",
	        loadMoreNr:"on",
	        loadMoreEndTxt:"No More Items for the Selected Filter",
	        loadMoreItems:[
					[830, [-1, 33, 34, 37]],
					[831, [-1, 33, 36, 35]],
					[832, [-1, 33, 35, 34]]],
	        row:9999,
	        loadMoreAjaxToken:"f7b1bc01e5",
	        loadMoreAjaxUrl:"/",
	        loadMoreAjaxAction:"Essential_Grid_Front_request_ajax",
	        ajaxContentTarget:"ess-grid-ajax-container-",
	        ajaxScrollToOffset:"0",
	        ajaxCloseButton:"off",
	        ajaxContentSliding:"on",
	        ajaxScrollToOnLoad:"on",
	        ajaxNavButton:"off",
	        ajaxCloseType:"type1",
	        ajaxCloseInner:"false",
	        ajaxCloseStyle:"light",
	        ajaxClosePosition:"tr",
	        space:3,
	        pageAnimation:"fade",
	        paginationScrollToTop:"off",
	        spinner:"spinner0",
	        lightBoxMode:"single",
	        animSpeed:1000,
	        delayBasic:1,
	        mainhoverdelay:1,
	        filterType:"single",
	        showDropFilter:"hover",
	        filterGroupClass:"esg-fgc-2",
	        googleFonts:['Open+Sans:300,400,600,700,800','Raleway:100,200,300,400,500,600,700,800,900','Droid+Serif:400,700'],
	        responsiveEntries: [
							{ width:1400,amount:3},
							{ width:1170,amount:3},
							{ width:1024,amount:3},
							{ width:960,amount:3},
							{ width:778,amount:3},
							{ width:640,amount:3},
							{ width:480,amount:1}
							]
		});

		try{
			jQuery("#esg-grid-2-1 .esgbox").esgbox({
				padding : [0,0,0,0],
		      	afterLoad:function() { 
		 		if (this.element.hasClass("esgboxhtml5")) {
				   var mp = this.element.data("mp4"),
				      ogv = this.element.data("ogv"),
				      webm = this.element.data("webm");
		         this.content ='<div style="width:100%;height:100%;"><video autoplay="true" loop="" class="rowbgimage" poster="" width="100%" height="auto"><source src="'+mp+'" type="video/mp4"><source src="'+webm+'" type="video/webm"><source src="'+ogv+'" type="video/ogg"></video></div>';	
				   var riint = setInterval(function() {jQuery(window).trigger("resize");},100); setTimeout(function() {clearInterval(riint);},2500);
				   };
				 },
				beforeShow : function () { 
					this.title = jQuery(this.element).attr('lgtitle');
					if (this.title) {
						this.title="";
		   		this.title =  '<div style="padding:0px 0px 0px 0px">'+this.title+'</div>';
					}
				},
				afterShow : function() {
				},
				openEffect : 'fade',
				closeEffect : 'fade',
				nextEffect : 'fade',
				prevEffect : 'fade',
				openSpeed : 'normal',
				closeSpeed : 'normal',
				nextSpeed : 'normal',
				prevSpeed : 'normal',
				helpers : {
					media : {},
				    title : {
						type:""
					}
				}
			});

	 	} 
	 	catch (e) {}
	}

	if (jQuery("#esg-grid-1-1").length > 0) {
		"use strict";
		function eggbfc(winw,resultoption) {
			var lasttop = winw,
			lastbottom = 0,
			smallest =9999,
			largest = 0,
			samount = 0,
			lamoung = 0,
			lastamount = 0,
			resultid = 0,
			resultidb = 0,
			responsiveEntries = [
								{ width:1400,amount:3},
								{ width:1170,amount:3},
								{ width:1024,amount:3},
								{ width:960,amount:3},
								{ width:778,amount:3},
								{ width:640,amount:3},
								{ width:480,amount:1}
								];
			if (responsiveEntries!=undefined && responsiveEntries.length>0)
				jQuery.each(responsiveEntries, function(index,obj) {
					var curw = obj.width != undefined ? obj.width : 0,
						cura = obj.amount != undefined ? obj.amount : 0;
					if (smallest>curw) {
						smallest = curw;
						samount = cura;
						resultidb = index;
					}
					if (largest<curw) {
						largest = curw;
						lamount = cura;
					}
					if (curw>lastbottom && curw<=lasttop) {
						lastbottom = curw;
						lastamount = cura;
						resultid = index;
					}
				})
				if (smallest>winw) {
					lastamount = samount;
					resultid = resultidb;
				}
				var obj = new Object;
				obj.index = resultid;
				obj.column = lastamount;
				if (resultoption=="id")
					return obj;
				else
					return lastamount;
		}
		if ("even"=="even") {
			var coh=0,
				container = jQuery("#esg-grid-1-1");
			var	cwidth = container.width(),
				ar = "4:3",
				gbfc = eggbfc(jQuery(window).width(),"id"),
				row = 2;
				ar = ar.split(":");
				aratio=parseInt(ar[0],0) / parseInt(ar[1],0);
				coh = cwidth / aratio;
				coh = coh/gbfc.column*row;
			var ul = container.find("ul").first();
			ul.css({display:"block",height:coh+"px"});
		}
		var essapi_1;
		essapi_1 = jQuery("#esg-grid-1-1").tpessential({
	        gridID:1,
	        layout:"even",
	        forceFullWidth:"off",
	        lazyLoad:"off",
	        gridID:"1",
	        loadMoreType:"button",
	        loadMoreAmount:3,
	        loadMoreTxt:"View More",
	        loadMoreNr:"on",
	        loadMoreEndTxt:"No More Items for the Selected Filter",
	        loadMoreItems:[
					[830, [-1, 33, 34, 37]],
					[831, [-1, 33, 36, 35]],
					[832, [-1, 33, 35, 34]]],
	        row:9999,
	        loadMoreAjaxToken:"f7b1bc01e5",
	        loadMoreAjaxUrl:"/",
	        loadMoreAjaxAction:"Essential_Grid_Front_request_ajax",
	        ajaxContentTarget:"ess-grid-ajax-container-",
	        ajaxScrollToOffset:"0",
	        ajaxCloseButton:"off",
	        ajaxContentSliding:"on",
	        ajaxScrollToOnLoad:"on",
	        ajaxNavButton:"off",
	        ajaxCloseType:"type1",
	        ajaxCloseInner:"false",
	        ajaxCloseStyle:"light",
	        ajaxClosePosition:"tr",
	        space:3,
	        pageAnimation:"fade",
	        paginationScrollToTop:"off",
	        spinner:"spinner0",
	        evenGridMasonrySkinPusher:"off",
	        lightBoxMode:"single",
	        animSpeed:1000,
	        delayBasic:1,
	        mainhoverdelay:1,
	        filterType:"single",
	        showDropFilter:"hover",
	        filterGroupClass:"esg-fgc-1",
	        googleFonts:['Open+Sans:300,400,600,700,800','Raleway:100,200,300,400,500,600,700,800,900','Droid+Serif:400,700'],
	        aspectratio:"4:3",
	        responsiveEntries: [
							{ width:1400,amount:3},
							{ width:1170,amount:3},
							{ width:1024,amount:3},
							{ width:960,amount:3},
							{ width:778,amount:3},
							{ width:640,amount:3},
							{ width:480,amount:1}
							]
		});

		try{
			jQuery("#esg-grid-1-1 .esgbox").esgbox({
				padding : [0,0,0,0],
		      	afterLoad:function() { 
			 		if (this.element.hasClass("esgboxhtml5")) {
					   	var mp = this.element.data("mp4"),
					      	ogv = this.element.data("ogv"),
					      	webm = this.element.data("webm");
			         		this.content ='<div style="width:100%;height:100%;"><video autoplay="true" loop="" class="rowbgimage" poster="" width="100%" height="auto"><source src="'+mp+'" type="video/mp4"><source src="'+webm+'" type="video/webm"><source src="'+ogv+'" type="video/ogg"></video></div>';	
					   	var riint = setInterval(function() {jQuery(window).trigger("resize");},100); setTimeout(function() {clearInterval(riint);},2500);
				   	};
				},
				beforeShow : function () { 
					this.title = jQuery(this.element).attr('lgtitle');
					if (this.title) {
						this.title="";
		   				this.title =  '<div style="padding:0px 0px 0px 0px">'+this.title+'</div>';
					}
				},
				afterShow : function() {
				},
				openEffect : 'fade',
				closeEffect : 'fade',
				nextEffect : 'fade',
				prevEffect : 'fade',
				openSpeed : 'normal',
				closeSpeed : 'normal',
				nextSpeed : 'normal',
				prevSpeed : 'normal',
				helpers : {
					media : {},
				    title : {
						type:""
					}
				}
			});

	 	} 

	 	catch (e) {}
	}

	if (jQuery("#esg-grid-3-1").length > 0) {
		"use strict";
		function eggbfc(winw,resultoption) {
			var lasttop = winw,
				lastbottom = 0,
				smallest =9999,
				largest = 0,
				samount = 0,
				lamoung = 0,
				lastamount = 0,
				resultid = 0,
				resultidb = 0,
				responsiveEntries = [
								{ width:1400,amount:3},
								{ width:1170,amount:3},
								{ width:1024,amount:3},
								{ width:960,amount:3},
								{ width:778,amount:3},
								{ width:640,amount:3},
								{ width:480,amount:1}
								];
			if (responsiveEntries!=undefined && responsiveEntries.length>0)
				jQuery.each(responsiveEntries, function(index,obj) {
					var curw = obj.width != undefined ? obj.width : 0,
						cura = obj.amount != undefined ? obj.amount : 0;
					if (smallest>curw) {
						smallest = curw;
						samount = cura;
						resultidb = index;
					}
					if (largest<curw) {
						largest = curw;
						lamount = cura;
					}
					if (curw>lastbottom && curw<=lasttop) {
						lastbottom = curw;
						lastamount = cura;
						resultid = index;
					}
			})
			if (smallest>winw) {
				lastamount = samount;
				resultid = resultidb;
			}
			var obj = new Object;
			obj.index = resultid;
			obj.column = lastamount;
			if (resultoption=="id")
				return obj;
			else
				return lastamount;
		}
		if ("cobbles"=="even") {
			var coh=0,
				container = jQuery("#esg-grid-3-1");
			var	cwidth = container.width(),
				ar = "4:3",
				gbfc = eggbfc(jQuery(window).width(),"id"),
				row = 3;
				ar = ar.split(":");
				aratio=parseInt(ar[0],0) / parseInt(ar[1],0);
				coh = cwidth / aratio;
				coh = coh/gbfc.column*row;
			var ul = container.find("ul").first();
				ul.css({display:"block",height:coh+"px"});
		}
		var essapi_3;
		essapi_3 = jQuery("#esg-grid-3-1").tpessential({
		    gridID:3,
		    layout:"cobbles",
		    forceFullWidth:"off",
		    lazyLoad:"off",
		    row:3,
		    loadMoreAjaxToken:"f7b1bc01e5",
		    loadMoreAjaxUrl:"/",
		    loadMoreAjaxAction:"Essential_Grid_Front_request_ajax",
		    ajaxContentTarget:"ess-grid-ajax-container-",
		    ajaxScrollToOffset:"0",
		    ajaxCloseButton:"off",
		    ajaxContentSliding:"on",
		    ajaxScrollToOnLoad:"on",
		    ajaxNavButton:"off",
		    ajaxCloseType:"type1",
		    ajaxCloseInner:"false",
		    ajaxCloseStyle:"light",
		    ajaxClosePosition:"tr",
		    space:3,
		    pageAnimation:"fade",
		    paginationScrollToTop:"off",
		    spinner:"spinner0",
		    lightBoxMode:"single",
		    animSpeed:1000,
		    delayBasic:1,
		    mainhoverdelay:1,
		    filterType:"single",
		    showDropFilter:"hover",
		    filterGroupClass:"esg-fgc-3",
		    googleFonts:['Open+Sans:300,400,600,700,800','Raleway:100,200,300,400,500,600,700,800,900','Droid+Serif:400,700'],
		    aspectratio:"4:3",
		    responsiveEntries: [
							{ width:1400,amount:3},
							{ width:1170,amount:3},
							{ width:1024,amount:3},
							{ width:960,amount:3},
							{ width:778,amount:3},
							{ width:640,amount:3},
							{ width:480,amount:1}
							]
		});

		try{
			jQuery("#esg-grid-3-1 .esgbox").esgbox({
				padding : [0,0,0,0],
		      	afterLoad:function() { 
			 		if (this.element.hasClass("esgboxhtml5")) {
					   	var mp = this.element.data("mp4"),
					      	ogv = this.element.data("ogv"),
					      	webm = this.element.data("webm");
			         		this.content ='<div style="width:100%;height:100%;"><video autoplay="true" loop="" class="rowbgimage" poster="" width="100%" height="auto"><source src="'+mp+'" type="video/mp4"><source src="'+webm+'" type="video/webm"><source src="'+ogv+'" type="video/ogg"></video></div>';	
					   var riint = setInterval(function() {jQuery(window).trigger("resize");},100); setTimeout(function() {clearInterval(riint);},2500);
				   	};
			 	},
				beforeShow : function () { 
					this.title = jQuery(this.element).attr('lgtitle');
					if (this.title) {
						this.title="";
							this.title =  '<div style="padding:0px 0px 0px 0px">'+this.title+'</div>';
					}
				},
				afterShow : function() {
				},
				openEffect : 'fade',
				closeEffect : 'fade',
				nextEffect : 'fade',
				prevEffect : 'fade',
				openSpeed : 'normal',
				closeSpeed : 'normal',
				nextSpeed : 'normal',
				prevSpeed : 'normal',
				helpers : {
					media : {},
				    title : {
						type:""
					}
				}
			});
		} 
		catch (e) {}
	}
}

/*reviews stars*/
function reviews_stars() {
    "use strict";
    if (jQuery(".reviews_stars").length > 0) {
        jQuery(".reviews_stars").each(function() {
            var percent = jQuery(this).attr("data-mark") * 20;
            jQuery(this).find('.reviews_stars_hover').css({'width': percent + '%'});
        });
    }
}

/* pie skills legend color */
function pie_skills_legend_color() {
    "use strict";

    if (jQuery(".sc_skills_pie").length > 0) {

		var skillspiecolor = $('input.color','.pie').map(function(){
		   return $(this).attr("value");
		}).get();

		var skillspielegend = $('.sc_skills_legend_marker','.sc_skills_legend').map(function(){
		   return $(this);
		}).get();

		skillspielegend[0].css({'background-color': skillspiecolor[0]});
		skillspielegend[1].css({'background-color': skillspiecolor[1]});
		skillspielegend[2].css({'background-color': skillspiecolor[2]});
		skillspielegend[3].css({'background-color': skillspiecolor[3]});

    }
}

// Price range slider
function price_filter() {
    "use strict";
    if (jQuery("#slider-range").length > 0) {
        jQuery("#slider-range").slider({
            range: true,
            min: 0,
            max: 250,
            values: [0, 250],
            slide: function(event, ui) {
                jQuery("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
            }
        });
        jQuery("#amount").val("$" + jQuery("#slider-range").slider("values", 0) +
            " - $" + jQuery("#slider-range").slider("values", 1));
    }
}

function woo_ship_calc() {
   	"use strict";
	if (jQuery("#shipping_method_0").length > 0) {
		jQuery('.shipping-calculator-button').on('click' ,function(e){
			"use strict";
			if (jQuery('.shipping-calculator-form').hasClass('open-shipping-calculator-form'))
				jQuery('.shipping-calculator-form').removeClass('open-shipping-calculator-form');
			else {
				jQuery('.shipping-calculator-form').addClass('open-shipping-calculator-form');
			}
			e.preventDefault();
			return false;
		});
	}
	if (jQuery("body.woocommerce-checkout").length > 0) {
		jQuery(".showlogin", ".woocommerce-info").on('click' ,function(e){
			"use strict";
			if (jQuery('.login_woo_checkout','.woocommerce').hasClass('open_login_woo_checkout'))
				jQuery('.login_woo_checkout','.woocommerce').removeClass('open_login_woo_checkout');
			else {
				jQuery('.login_woo_checkout','.woocommerce').addClass('open_login_woo_checkout');
			}
			e.preventDefault();
			return false;
		});

		jQuery(".showcoupon", ".woocommerce-info").on('click' ,function(e){
			"use strict";
			if (jQuery('.coupon_woo_checkout','.woocommerce').hasClass('open_coupon_woo_checkout'))
				jQuery('.coupon_woo_checkout','.woocommerce').removeClass('open_coupon_woo_checkout');
			else {
				jQuery('.coupon_woo_checkout','.woocommerce').addClass('open_coupon_woo_checkout');
			}
			e.preventDefault();
			return false;
		});

		jQuery('#ship-to-different-address-checkbox').change(function(){
			if (jQuery('.shipping_woo_address','.woocommerce-shipping-fields').hasClass('open_shipping_woo_checkout'))
				jQuery('.shipping_woo_address','.woocommerce-shipping-fields').removeClass('open_shipping_woo_checkout');
			else {
				jQuery('.shipping_woo_address','.woocommerce-shipping-fields').addClass('open_shipping_woo_checkout');
			}
		});
		jQuery('#createaccount').change(function(){
			if (jQuery('.create-woo-account','.woocommerce-billing-fields').hasClass('open-create-woo-account'))
				jQuery('.create-woo-account','.woocommerce-billing-fields').removeClass('open-create-woo-account');
			else {
				jQuery('.create-woo-account','.woocommerce-billing-fields').addClass('open-create-woo-account');
			}
		});
	}
}