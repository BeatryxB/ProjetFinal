<%--
  Created by IntelliJ IDEA.
  User: BBeugnet
  Date: 23/04/2021
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<div class="div_res">
  <table class="table">
    <thead class=".thead-light">
    <tr>
      <td>Title</td>
      <td>Description</td>
      <td>Type</td>
      <td>Date</td>
      <td>Time</td>
      <td>Localisation</td>
      <td>Delete ?</td>
    </tr>
    </thead>

    <c:forEach items = "${res}" var="reservation">
      <tbody>
      <tr>
        <td><c:out value="${reservation.event.titre}"/></td>
        <td><c:out value="${reservation.event.description}"/></td>
        <td><c:out value="${reservation.event.type.typeField}"/></td>
        <td><c:out value="${reservation.event.date}"/></td>
        <td><c:out value="${reservation.event.time}"/></td>
        <td><c:out value="${reservation.event.localisation}"/></td>
        <td><a href="/deleteres/${reservation.idReservation}" class="btn btn-danger">Delete this participation</a></td>
      </tr>
      </tbody>
    </c:forEach>
  </table>
</div>