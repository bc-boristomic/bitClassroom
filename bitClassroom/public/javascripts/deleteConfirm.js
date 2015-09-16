
$('body').on('click', 'a[data-role="delete"]', function(e){
    e.preventDefault();
    $toDelete = $(this);
    var conf = bootbox.confirm("Are you sure?", function(result){
        if(result != false){
            $.ajax({
                url: $toDelete.attr("href"),
                method: "delete"
            }).success(function(response){
                $toDelete.parents($toDelete.attr("data-delete-parent")).remove();
            });
        }
    });


});