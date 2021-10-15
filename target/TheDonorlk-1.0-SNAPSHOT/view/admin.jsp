<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>TheDonor.lk</title>
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css">
</head>

<body>
<main>
    <div class="recent-grid">
        <div class="card">
            <div class="card-header">
                <h3>System Admins</h3>
                <div class="search-wrapper">
                    <span class="las la-search"></span>
                    <input type="search" placeholder="search here" />
                </div>
                <div class="buttons">
                    <button>Delete</button>
                    <button id="newBtn">New</button>
                </div>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table width="100%">
                        <thead>
                        <tr>
                            <td>Admin ID</td>
                            <td>Username</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>#DC101</td>
                            <td>jamie_stark</td>

                        </tr>
                        <tr>
                            <td>#DC102</td>
                            <td>susan_helen</td>

                        </tr>
                        <tr>
                            <td>#DC103</td>
                            <td>audrey_b</td>

                        </tr>
                        <tr>
                            <td>#DC104</td>
                            <td>selena_009</td>

                        </tr>
                        <tr>
                            <td>#DC105</td>
                            <td>bob_mart</td>

                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

<!-- The Popup Modal -->
<div id="myModal" class="modal">
    <div class="modal-content">
        <div class="modal-header">
            <span class="close-popup">&times;</span>
            <h3>Enter Admin Details</h3>
        </div>

        <div class="modal-body">
            <!-- The form inside popup modal -->
            <form>
                <div class="fields">
                    <div class="field-single">
                        <span>Username</span>
                        <input type="text" />
                    </div>
                    <br>
                    <p>(Username should be a valid email address)</p>
                </div>
                <div class="modal-submit-button">
                    <div class="buttons">
                        <button type="submit">Submit</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="modal-footer">
            <img src="<%=request.getContextPath()%>/public/images/Logo - White.png" height="100px">
            <p>Many people would not be alive today if it wasn't for the generosity of our donors. <br>Donating
                Blood Makes a Big Difference in the Lives of Others.
            </p>
        </div>
    </div>

    <!-- IMPORTANT -->
    <!-- Javascript file with popup modal function should be called here just after the popup modal -->
    <script src="<%=request.getContextPath()%>/public/scripts/popup_modal.js"></script>
</div>

</body>

</html>
