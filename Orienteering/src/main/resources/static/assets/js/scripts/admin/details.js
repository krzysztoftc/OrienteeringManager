/**
 * Created by krzysztof on 26.05.16.
 */

function toogle(id) {
   $("#option"+id).slideToggle("fast");
}

function save_competitor(button) {

    console.log("Save competitor: ",button);

    var parent = button.parent();
    console.log(parent);

   }

$(document).on('click','.save',function () {
    var id = this.id.split("_")[2];

    var options = {'competitor'  : id};
    var caterings = new Array();
    var nights = new Array();

    var form = $("#comp_options_" +id + " > table").each(function () {

        $(this).find("input").each(function () {
            if ($(this).is(":checked")) {
                var check_id =$(this).attr('class').split("_");
                if (check_id[0] == "meal")
                    caterings.push(check_id[1]);

                if (check_id[0] == "night")
                    nights.push(check_id[1]);
            }
        })
    });

    options['nights'] = nights;
    options['caterings'] = caterings;

    var result = JSON.stringify(options);
    console.log(result);

    $.post("/admin/save_competitor",result,function (){
        console.log("Send with succes");
    }
    );
});