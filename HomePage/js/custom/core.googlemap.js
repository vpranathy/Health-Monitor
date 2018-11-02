function oldstory_googlemap_init(dom_obj, coords) {
	"use strict";
	if (typeof OLDSTORY_STORAGE['googlemap_init_obj'] == 'undefined') oldstory_googlemap_init_styles();
	OLDSTORY_STORAGE['googlemap_init_obj'].geocoder = '';
	try {
		var id = dom_obj.id;
		OLDSTORY_STORAGE['googlemap_init_obj'][id] = {
			dom: dom_obj,
			markers: coords.markers,
			geocoder_request: false,
			opt: {
				zoom: coords.zoom,
				center: null,
				scrollwheel: false,
				scaleControl: false,
				disableDefaultUI: false,
				panControl: true,
				zoomControl: true, //zoom
				mapTypeControl: false,
				streetViewControl: false,
				overviewMapControl: false,
				styles: OLDSTORY_STORAGE['googlemap_styles'][coords.style ? coords.style : 'default'],
				mapTypeId: google.maps.MapTypeId.ROADMAP
			}
		};
		
		oldstory_googlemap_create(id);

	} catch (e) {
		
		dcl(OLDSTORY_STORAGE['strings']['googlemap_not_avail']);

	};
}

function oldstory_googlemap_create(id) {
	"use strict";

	// Create map
	OLDSTORY_STORAGE['googlemap_init_obj'][id].map = new google.maps.Map(OLDSTORY_STORAGE['googlemap_init_obj'][id].dom, OLDSTORY_STORAGE['googlemap_init_obj'][id].opt);

	// Add markers
	for (var i in OLDSTORY_STORAGE['googlemap_init_obj'][id].markers)
		OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].inited = false;
	oldstory_googlemap_add_markers(id);
	
	// Add resize listener
	jQuery(window).resize(function() {
		if (OLDSTORY_STORAGE['googlemap_init_obj'][id].map)
			OLDSTORY_STORAGE['googlemap_init_obj'][id].map.setCenter(OLDSTORY_STORAGE['googlemap_init_obj'][id].opt.center);
	});
}

function oldstory_googlemap_add_markers(id) {
	"use strict";
	for (var i in OLDSTORY_STORAGE['googlemap_init_obj'][id].markers) {
		
		if (OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].inited) continue;
		
		if (OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].latlng == '') {
			
			if (OLDSTORY_STORAGE['googlemap_init_obj'][id].geocoder_request!==false) continue;
			
			if (OLDSTORY_STORAGE['googlemap_init_obj'].geocoder == '') OLDSTORY_STORAGE['googlemap_init_obj'].geocoder = new google.maps.Geocoder();
			OLDSTORY_STORAGE['googlemap_init_obj'][id].geocoder_request = i;
			OLDSTORY_STORAGE['googlemap_init_obj'].geocoder.geocode({address: OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].address}, function(results, status) {
				"use strict";
				if (status == google.maps.GeocoderStatus.OK) {
					var idx = OLDSTORY_STORAGE['googlemap_init_obj'][id].geocoder_request;
					if (results[0].geometry.location.lat && results[0].geometry.location.lng) {
						OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[idx].latlng = '' + results[0].geometry.location.lat() + ',' + results[0].geometry.location.lng();
					} else {
						OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[idx].latlng = results[0].geometry.location.toString().replace(/\(\)/g, '');
					}
					OLDSTORY_STORAGE['googlemap_init_obj'][id].geocoder_request = false;
					setTimeout(function() { 
						oldstory_googlemap_add_markers(id); 
						}, 200);
				} else
					dcl(OLDSTORY_STORAGE['strings']['geocode_error'] + ' ' + status);
			});
		
		} else {
			
			// Prepare marker object
			var latlngStr = OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].latlng.split(',');
			var markerInit = {
				map: OLDSTORY_STORAGE['googlemap_init_obj'][id].map,
				position: new google.maps.LatLng(latlngStr[0], latlngStr[1]),
				clickable: OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].description!=''
			};
			if (OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].point) markerInit.icon = OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].point;
			if (OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].title) markerInit.title = OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].title;
			OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].marker = new google.maps.Marker(markerInit);
			
			// Set Map center
			if (OLDSTORY_STORAGE['googlemap_init_obj'][id].opt.center == null) {
				OLDSTORY_STORAGE['googlemap_init_obj'][id].opt.center = markerInit.position;
				OLDSTORY_STORAGE['googlemap_init_obj'][id].map.setCenter(OLDSTORY_STORAGE['googlemap_init_obj'][id].opt.center);				
			}
			
			// Add description window
			if (OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].description!='') {
				OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].infowindow = new google.maps.InfoWindow({
					content: OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].description
				});
				google.maps.event.addListener(OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].marker, "click", function(e) {
					var latlng = e.latLng.toString().replace("(", '').replace(")", "").replace(" ", "");
					for (var i in OLDSTORY_STORAGE['googlemap_init_obj'][id].markers) {
						if (latlng == OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].latlng) {
							OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].infowindow.open(
								OLDSTORY_STORAGE['googlemap_init_obj'][id].map,
								OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].marker
							);
							break;
						}
					}
				});
			}
			
			OLDSTORY_STORAGE['googlemap_init_obj'][id].markers[i].inited = true;
		}
	}
}

function oldstory_googlemap_refresh() {
	"use strict";
	for (id in OLDSTORY_STORAGE['googlemap_init_obj']) {
		oldstory_googlemap_create(id);
	}
}

function oldstory_googlemap_init_styles() {
	"use strict";
	// Init Google map
	OLDSTORY_STORAGE['googlemap_init_obj'] = {};
	OLDSTORY_STORAGE['googlemap_styles'] = {
		'default': []
	};
	if (window.oldstory_theme_googlemap_styles!==undefined)
		OLDSTORY_STORAGE['googlemap_styles'] = oldstory_theme_googlemap_styles(OLDSTORY_STORAGE['googlemap_styles']);
}