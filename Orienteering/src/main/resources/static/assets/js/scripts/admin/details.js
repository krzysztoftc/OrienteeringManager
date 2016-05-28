/**
 * Created by krzysztof on 26.05.16.
 */

function toogle(id) {
   $("#option"+id).slideToggle("fast");
}

function save_competitor(form) {

    console.log("Save competitor ", form);


   }

$('').submit(function () {
   save_competitor()
   return false;
});

