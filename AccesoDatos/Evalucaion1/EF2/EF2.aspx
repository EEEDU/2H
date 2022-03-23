<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="EF2.aspx.cs" Inherits="EF2.EF2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" DataSourceID="EntityDataSource1"></asp:GridView>
            <asp:EntityDataSource ID="EntityDataSource1" runat="server"></asp:EntityDataSource>
        </div>
    </form>
</body>
</html>
