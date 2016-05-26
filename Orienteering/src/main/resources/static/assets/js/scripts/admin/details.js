/**
 * Created by krzysztof on 26.05.16.
 */

function toogle(id) {
    console.log(id);
    console.log($("#option"+id));
   $("#option"+id).slideToggle("fast");
}

$().ready(function () {
    $(".option").hide();
   
});