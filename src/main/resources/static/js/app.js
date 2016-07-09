$(document).ready(function() {
    $(document).on('click', '#create-task', function(e) {
        e.preventDefault();

        $.ajax({
            type: 'POST',
            url: '/task/new',
            data: JSON.stringify({
                description: $('#task-description').val(),
                deadline: $('#task-deadline').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function(data, status) {
            $('#add-modal').modal('hide');
            location.reload();
        });
    });
});