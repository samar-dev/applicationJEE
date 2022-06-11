<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">   		
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>   
    </head>

    <body>          
        <div class="container">
            <h2>Liste des utilisateurs</h2>
            <!--Search Form -->
            <form action="${pageContext.request.contextPath}/Consulter" method="get" id="seachUserForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="userName" id="userName" class="form-control" required="true" placeholder="Taper le nom, prenom ou le login de l'utilisateur"/>                    
                </div>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Rechercher
                </button>
                <br></br>
                <br></br>
            </form>

            <!--Employees List-->
            <c:if test="${not empty message}">                
                <div class="alert alert-success">
                    ${message}
                </div>
            </c:if> 
            <form action="${pageContext.request.contextPath}/Consulter" method="post" id="userForm" role="form" >              
                <input type="hidden" id="idUser" name="idUser">
                <input type="hidden" id="action" name="action">
                <c:choose>
                    <c:when test="${not empty usersList}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>User Id</td>
                                    <td>Nom</td>
                                    <td>Prenom</td>
                                    <td>Login</td>
                                    <td>Mot de passe</td>
                               
                                    <td></td>
                                </tr>
                            </thead>
                            <c:forEach var="user" items="${usersList}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${iduser == user.iduser}">                        	
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    <td>
                                        <a href="${pageContext.request.contextPath}/AfficherUser?idUser=${user.iduser}">${user.iduser}</a> 
                                    </td>                                    
                                    <td>${user.iduser}</td>
                                    <td>${user.nom}</td>
                                    <td>${user.prenom}</td>
                                    <td>${user.login}</td>
                                    <td>${user.password}</td>
                                    <td><a href="#" id="remove" 
                                           onclick="document.getElementById('action').value = 'remove';document.getElementById('idUser').value = '${user.iduser}';
                                                    document.getElementById('userForm').submit();"> 
                                            <span class="glyphicon glyphicon-trash"/>
                                        </a>
                                                   
                                    </td>
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                           Aucuns utilisateurs trouvées
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            <form action ="jsp/nouveauUser.jsp">            
                <br></br>
                <button type="submit" class="btn btn-primary  btn-md">Nouveau Utilisateur</button> 
            </form>
        </div>
    </body>
</html>