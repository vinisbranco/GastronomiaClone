<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper pageTitle="Login">
    <jsp:attribute name="scripts">
        <script type="text/javascript" src="./assets/js/jquery.mask.min.js"></script>
        <script type="text/javascript" src="./assets/js/login/login.js"></script>
        <script type="text/javascript" src="./assets/js/forgotPassword/forgotPassword.js"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="container" style="margin-top: 50px; width: 70%;">
            <div class="text-center">
                <img src="./assets/img/ages-completo.png" alt="Ideias AGES"/>
            </div>
            <div id="loginbox" style="margin-top:50px;"
                 class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title" style="text-align:center; font-weight:bold;">Gastronomia</div>
                    </div>
                    <div style="padding-top:30px" class="panel-body">
                        <div style="display:none; text-align: center;" id="login-alert" class="alert alert-danger col-sm-12"></div>
                        <form id="formLogin" class="form-horizontal" role="form">
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="username" type="text" class="form-control" name="username"
                                       placeholder="Matricula ou E-mail">
                            </div>
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="password" type="password" class="form-control" name="password"
                                       placeholder="Senha">
                            </div>
                            <div style="margin-top:10px" class="form-group">
                                <!-- Button -->
                                <div class="col-sm-12 controls">
                                    <a id="btn-login" type="submit" style="float:right;" href="#" class="btn btn-success">Entrar </a>
                                </div>
                            </div>
                            <div class="form-group" style="">
                                <div class="col-md-12">
                                    <div style="padding-top:15px;border-top: 1px solid#888;"></div>
                                    <div style="float:right; font-size:85%;">
                                        Esqueceu a senha?
                                        <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                            Clique aqui!
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</t:wrapper>