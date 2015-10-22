

/* -------------------- *\
    #BACKSTRETCH CAROUSEL & FULLPAGE.JS
\* -------------------- */

$(window).load(function() {

    // Init Backstretch

    $(".backstretch-carousel").backstretch([
        "http://res.cloudinary.com/dsjagtpwx/image/upload/v1444657392/school-chalkboard_qxehfo.jpg",
        "http://res.cloudinary.com/dsjagtpwx/image/upload/v1444674131/4030153549_d507a2fdb3_o_ovokkq.jpg",
        "http://res.cloudinary.com/dsjagtpwx/image/upload/v1444674093/chalkboard-loop1_bquxjc.jpg",
        "http://res.cloudinary.com/dsjagtpwx/image/upload/v1444674117/HCD-green_chalkboard_komtog.jpg",
        "http://res.cloudinary.com/dsjagtpwx/image/upload/v1444674130/chalkboard_1_snalfw.jpg",
        "http://res.cloudinary.com/dsjagtpwx/image/upload/v1444654008/bg6_kxtrdv.jpg",
        "http://res.cloudinary.com/dsjagtpwx/image/upload/v1444674231/chalkboard_la5de8.jpg"
    ], {duration: 1000, fade: 700});

    // Pause Backstretch

    $(".backstretch-carousel").backstretch("pause");

    $('#fullpage').fullpage({

        // Plugin setup
        
        // Navigation
        anchors: ['home', 'about', 'features', 'contact'],
        menu: '.fullpage__nav',

        // Custom selectors
        sectionSelector: '.site-wrapper',

        //Scrolling
        scrollOverflow: true,

        onLeave: function(index, nextIndex, direction){

            // Make navbar active after leaving 1st section

            if(index == 1 && nextIndex != 1){
                $(".navbar").toggleClass("navbar__initial");
            }

            if(index != 1 && nextIndex == 1){
                $(".navbar").toggleClass("navbar__initial");
            }

            // Change Backstretch image on fullPage scroll

            $(".backstretch-carousel").backstretch("show", nextIndex-1)
        }
    });

});