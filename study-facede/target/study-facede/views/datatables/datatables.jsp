<%--
  Created by IntelliJ IDEA.
  User: Stone
  Date: 2017/4/14 0014
  Time: 下午 4:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>datatables</title>
    <%@ include file="../public.jsp" %>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/plugins/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/plugins/DataTables/media/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css"
          href="${ctx}/resources/plugins/DataTables/media/css/dataTables.bootstrap.css">
    <script type="text/javascript" charset="utf8"
            src="${ctx}/resources/plugins/DataTables/media/js/jquery.dataTables.js"></script>
    <script type="text/javascript" charset="utf8"
            src="${ctx}/resources/plugins/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" charset="utf8"
            src="${ctx}/resources/plugins/DataTables/media/js/dataTables.bootstrap.js"></script>
</head>
<body>
<table id="table_id" class="display">
    <thead>
    <tr>
        <th>no</th>
        <th>Name</th>
        <th>Position</th>
        <th>Office</th>
        <th>Extn.</th>
        <th>Start date</th>
        <th>Salary</th>
    </tr>
    </thead>
</table>
<script type="text/javascript">
    $(document).ready(function () {
        var datas = [
            {
                "name": "Tiger Nixon",
                "position": "System Architect",
                "salary": "$3,120",
                "start_date": "2011/04/25",
                "office": "Edinburgh",
                "extn": "5421"
            },
            {
                "name": "Garrett Winters",
                "position": "Director",
                "salary": "$5,300",
                "start_date": "2011/07/25",
                "office": "Edinburgh",
                "extn": "8422"
            }
        ];
        var datatables = $('#table_id').DataTable({
            data: datas,
            columns: [
                {data: null},
                {data: 'name'},
                {data: 'position'},
                {data: 'salary'},
                {data: 'state_date'},
                {data: 'office'},
                {data: 'extn'}
            ],
            "columnDefs": [{
                "targets": 0,
                "render": function (data, type, full, meta) {
                    return meta.row + 1;
                }
            }]
        });
        $("#table_id tbody").on('click', 'tr', function () {
            var d = datatables.row(this).data();
            alert(d.position);
        });
    });
</script>
</body>
</html>
