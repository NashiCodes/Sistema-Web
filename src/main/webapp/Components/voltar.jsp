<%
    String lastPage = request.getHeader("Referer");
    if (lastPage == null) {
        lastPage = "/";
    }
%>
<div class="col-md-12">
    <button type="button" class="btn btn-primary" onclick="window.location.href='<%=lastPage%>'">Voltar</button>
</div>
