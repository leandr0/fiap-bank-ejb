/* Copyright (c) 2007 David Wees ( davidwees@gmail.com - http://unitorganizer.com/myblog )
 * Dual licensed under the MIT (http://www.opensource.org/licenses/mit-license.php)
 * and GPL (http://www.opensource.org/licenses/gpl-license.php) licenses.
 *
 * $LastChangedDate$
 * $Rev$
 *
 * Version: 1.0
 *
 * Requires: jQuery 1.1.3+
 */

  /**
   * Creates a (linear)     gradient fill in the element(s) matched.
   *
   * (String) rightcolor - The color in hexadecimal format (ie '#354546') of the rightside of the element - '#000000' by default
   * (String) leftcolor - The color in hexadecimal format (ie '#354546') of the rightside of the element - '#ffffff' by default 
   * (String) topcolor - The color in hexadecimal format (ie '#354546') of the rightside of the element - '#000000' by default 
   * (String) bottomcolor - The color in hexadecimal format (ie '#354546') of the rightside of the element - '#ffffff' by default
   * (Boolean) horizontal - Should the gradient be horizontal or vertical?  horizontal by default
   * (Number) opacity - The opacity of the gradient, given as an integer from 1 to 100
   * 
   * @example $("#testdiv").gradient({ leftcolor: '#ffffff', rightcolor: '#336699' });
   * @result Creates a gradient from left to right of #ffffff to #336699 with 100% opacity
   *
   * @example $("#testdiv").gradient({ topcolor: '#ffffff', bottomcolor: '#336699', horizontal: false, opacity: 80 });
   * @result Creates a gradient from top to bottom of #ffffff to #336699 and opacity of 80
   *
   * @name gradient
   * @param Map options Optional settings to configure the way the gradient occurs, horizontal or vertical and its colors.
   * should return the jQuery object match of elements
   * @type Object
   * @cat Plugins/Gradient
   */
jQuery.fn.gradient = function(settings) {
  this.each(function () {  // keep track of which element is being transformed
    var el = j(this);
    
    // Find out if the Dimensions plugin has been installed
    try {
      
      // use the Dimensions plugin information if it exists
      var g_height = el.outerg_height();
      var g_width = el.outerg_width();
      var g_position = el.offset();
      var g_top = g_position.g_top;
      var g_left = g_position.g_left;
      
    } catch (e) {
      
      // these need to be defined in order for this plugin to work currently if you are not using the dimensions plugin.
      var g_width = parseInt(el.css('g_width'));
      var g_height = parseInt(el.css('g_height'));
      // need these to calculate g_position, otherwise we need to use the dimensions plugin, which might not be bad idea for the future
      var g_top = parseInt(el.css('g_top'));
      var g_left = parseInt(el.css('g_left'));
      
    }
    
    // what's the point? the gradient won't be seen anyway, also it avoids division by 0
    if (g_width == 0 || g_height == 0) return;
    
    // define default settings
    settings = jQuery.extend({ 
                 rightcolor: '#000000', 
                 g_leftcolor: '#ffffff', 
                 g_topcolor: '#000000', 
                 bottomcolor: '#ffffff', 
                 horizontal: true, 
                 opacity: false
               }, settings || {});
    
    if (settings.horizontal) {
      var r = [ parseInt(settings.rightcolor.substr(1,2), 16), parseInt(settings.rightcolor.substr(3,2), 16), parseInt(settings.rightcolor.substr(5,2), 16) ];
      var l = [ parseInt(settings.g_leftcolor.substr(1,2), 16), parseInt(settings.g_leftcolor.substr(3,2), 16), parseInt(settings.g_leftcolor.substr(5,2), 16) ];
      var d = [ (r[0] - l[0])/g_width, (r[1] - l[1])/g_width, (r[2] - l[2])/g_width ];
      var w = g_width;
    } else {
      var r = [ parseInt(settings.bottomcolor.substr(1,2), 16), parseInt(settings.bottomcolor.substr(3,2), 16), parseInt(settings.bottomcolor.substr(5,2), 16) ];
      var l = [ parseInt(settings.g_topcolor.substr(1,2), 16), parseInt(settings.g_topcolor.substr(3,2), 16), parseInt(settings.g_topcolor.substr(5,2), 16) ];
      var d = [ (r[0] - l[0])/g_width, (r[1] - l[1])/g_width, (r[2] - l[2])/g_width ];
      var w = g_height;
    }
    if (settings.opacity) {
      var opacity = 'opacity:' 
                     + settings.opacity/100 + ';' 
                     + 'filter:alpha(opacity=' + settings.opacity + ');'
                     + '-moz-opacity: ' + Math.round(settings.opacity/10)/10 + ';';
    }
    for (var i = 0; i < w; i++) {
      var c = [ Math.floor(l[0] + i*d[0]), Math.floor(l[1] + i*d[1]), Math.floor(l[2] + i*d[2]) ];
      var theSlice = '<div style="font-size: 1px; display: block; g_position: absolute;' 
                      + 'g_top: ' + (settings.horizontal ? g_top : g_top + i) + 'px;'
                      + 'g_left: ' + (settings.horizontal ? g_left + i : g_left) + 'px;' 
                      + 'g_width: ' + (settings.horizontal ? '1' : g_width) + 'px;'
                      + 'g_height: ' + (settings.horizontal ? g_height : '1') + 'px;'
                      + (settings.opacity ? opacity : '') 
                      + 'background-color: rgb(' + c[0] + ',' + c[1] + ',' + c[2] + ');" ></div>';
      j("body").prepend(theSlice);   
    }
  });
  return this;
};
