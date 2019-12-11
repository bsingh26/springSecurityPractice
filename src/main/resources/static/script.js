
/* Takes input on which button is clicked and which color should we change the background to and which item to display//
The way this functions workd  is there are four html divison elements : 
About Me , Resume , Interests , Contact Me So it will turn on the element which is clicked and disable the rest 3 elements
 */
function openMenu(menuItem, elmnt, color) {
    var i, tabcontent, tablinks;
    // Hide all menu
    tabcontent = document.getElementsByClassName("tabcontent");

    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    // reset colors for all buttons
    tablinks = document.getElementsByClassName("tablink");

    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "";
    }
    // Display the html div
    document.getElementById(menuItem).style.display = "block";
    // set current menu button to given color
    elmnt.style.backgroundColor = color;
}