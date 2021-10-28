function confirmation(ev) {
    ev.preventDefault();
    var urlToRedirect = ev.currentTarget.getAttribute('href'); //use currentTarget because the click may be on the nested i tag and not a tag causing the href to be empty
    console.log(urlToRedirect); // verify if this is the right URL
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover the user!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((willDelete) => {
            // redirect with javascript here as per your logic after showing the alert using the urlToRedirect value
            if (willDelete) {
                window.location.href=urlToRedirect;
                swal("Poof! Your imaginary file has been deleted!", {
                    icon: "success",
                });
            } else {
                swal("User is safe! and not deleted");
            }
        });
}