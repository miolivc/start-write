/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

addEventListener("load", function() {
    setTimeout(hideURLbar, 0);
}, false);

function hideURLbar(){
    window.scrollTo(0,1);
}

function criarBlog(){
    window.location.href = "criarBlog.jsp";
}

function listarBlogs(){
    window.location.href = "blogs.jsp";
}

function salvaNomePagina(){
    
}
