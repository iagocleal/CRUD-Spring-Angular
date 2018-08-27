$(document).ready(function() {
    $('[data-toggle=offcanvas]').click(function() {
        $('.row-offcanvas').toggleClass('active');
    });
    
    
    
});

$(window).bind("load", function () {
    // Remove splash screen after load
	//setTimeout( function(){$('.splash').css('display', 'none')}, 2000);
	$('.splash').css('display', 'none');
	
	// Sidebar menu
	$('#side-menu').metisMenu();
	
	// Sidebar Graphic
	/**
	 * TO-DO jogar esses dados pelo angularJS direto na página
	 */
	$("#sparkline1").sparkline([5, 6, 7, 2, 0, 4, 2, 4, 5, 7, 2, 4, 12, 11, 4], {
        type: 'bar',
        barWidth: 7,
        height: '30px',
        barColor: '#64a9a4',
        negBarColor: '#53ac2a'
    });
	
	// Handle minimalize sidebar menu
    $('.hide-menu').on('click', function(event){
        event.preventDefault();
        if ($(window).width() < 769) {
            $("body").toggleClass("show-sidebar");
        } else {
            $("body").toggleClass("hide-sidebar");
        }
    });

    // Function for small header
    $('.small-header-action').on('click', function(event){
        event.preventDefault();
        var icon = $(this).find('i:first');
        var breadcrumb  = $(this).parent().find('#hbreadcrumb');
        $(this).parent().parent().parent().toggleClass('small-header');
        breadcrumb.toggleClass('m-t-lg');
        icon.toggleClass('fa-arrow-up').toggleClass('fa-arrow-down');
    });

    
});