<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>servlet Scopes</title>
    </head>
    <body>                        
        <h1>Bienvenidos a servlet Scopes</h1>
        <h3>Un programa sencillo y didáctico para aprender y practicar variable scopes en los servlets<</h3>
        <hr/>
        <p>Instrucciones: debes probar el programa en ejecutando las parejas de sevlets con distintos parámetros en todas las siguientes combinaciones:</p>
        <ul>
            <li>Mismo navegador, mismo servlet en dos solapas distintas</li>
            <li>Mismo navegador, distinto servlet en dos solapas distintas</li>
            <li>Distinto navegador, mismo servlet</li>
            <li>Distinto navegador, distinto servlet</li>
        </ul>
        <p>Además, recargando la página en los controladores 3 y 4 puedes ver cómo afectan dinámicamente los incrementos de las variables en cada combinación. Y en cualquier momento puedes cerrar la sesión.</p>
        <p>Ojo: el parámetro servlet no es threat-safe</p>
        <p>Por último, el programa también sirve de modelo de implementación de log4j.</p>
        <hr/>
        <a href="controller01">1a: Controller01 (llamada sin parámetro)</a><br/>
        <a href="controller01?usuario=homer">2a: Controller01 (llamada con parámetro usuario=homer)</a><br/>
        <a href="controller01?usuario=march">3a: Controller01 (llamada con parámetro usuario=march)</a><br/>
        <a href="controller02">4a: Controller02 (llamada sin parámetro)</a><br/>
        <a href="controller02?usuario=homer">5a: Controller02 (llamada con parámetro usuario=homer)</a><br/>
        <a href="controller02?usuario=march">6a: Controller02 (llamada con parámetro usuario=march)</a><br/>
        <hr/>
        <a href="controller03">1b: Controller03  (llamada sin parámetro)</a><br/>
        <a href="controller03?intRequestScope=5">2b: Controller03 (llamada con parámetro intRequestScope=5)</a><br/>        
        <a href="controller04">3b: Controller04  (llamada sin parámetro)</a><br/>
        <a href="controller04?intRequestScope=5">4b: Controller03 (llamada con parámetro intRequestScope=5)</a><br/> 
        <hr/>
        <a href="controller05">1c: Controller05: Cerrar la sesión</a><br/>
    </body>
</html>
