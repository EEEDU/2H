<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Formulario.aspx.cs" Inherits="ExamenEduardo.Formulario" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" CellPadding="4" DataSourceID="ObjectDataSource1" ForeColor="#333333" GridLines="None">
                <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
                <Columns>
                    <asp:BoundField DataField="ProductoId" HeaderText="ProductoId" SortExpression="ProductoId" />
                    <asp:BoundField DataField="ProdcutoNombre" HeaderText="ProdcutoNombre" SortExpression="ProdcutoNombre" />
                    <asp:BoundField DataField="ProductoPrecio" HeaderText="ProductoPrecio" SortExpression="ProductoPrecio" />
                </Columns>
                <EditRowStyle BackColor="#999999" />
                <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
                <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
                <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
                <SortedAscendingCellStyle BackColor="#E9E7E2" />
                <SortedAscendingHeaderStyle BackColor="#506C8C" />
                <SortedDescendingCellStyle BackColor="#FFFDF8" />
                <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
            </asp:GridView>
            <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" SelectMethod="GetProducts" TypeName="ExamenEduardo.ExamenRepositorio"></asp:ObjectDataSource>
            <asp:GridView ID="GridView2" runat="server" AutoGenerateColumns="False" CellPadding="4" DataSourceID="ObjectDataSource2" ForeColor="#333333" GridLines="None">
                <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
                <Columns>
                    <asp:BoundField DataField="MarcaId" HeaderText="MarcaId" SortExpression="MarcaId" />
                    <asp:BoundField DataField="MarcaNombre" HeaderText="MarcaNombre" SortExpression="MarcaNombre" />
                </Columns>
                <EditRowStyle BackColor="#999999" />
                <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
                <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
                <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
                <SortedAscendingCellStyle BackColor="#E9E7E2" />
                <SortedAscendingHeaderStyle BackColor="#506C8C" />
                <SortedDescendingCellStyle BackColor="#FFFDF8" />
                <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
            </asp:GridView>
        </div>
        <asp:ObjectDataSource ID="ObjectDataSource2" runat="server" SelectMethod="GetMarcas" TypeName="ExamenEduardo.ExamenRepositorio"></asp:ObjectDataSource>
        <asp:GridView ID="GridView5" runat="server" AutoGenerateColumns="False" CellPadding="4" DataSourceID="ObjectDataSource4" ForeColor="#333333" GridLines="None">
            <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
            <Columns>
                <asp:BoundField DataField="ComponenteId" HeaderText="ComponenteId" SortExpression="ComponenteId" />
                <asp:BoundField DataField="ComponenteNombre" HeaderText="ComponenteNombre" SortExpression="ComponenteNombre" />
                <asp:BoundField DataField="ComponenteNumUnidades" HeaderText="ComponenteNumUnidades" SortExpression="ComponenteNumUnidades" />
                <asp:BoundField DataField="Precio" HeaderText="Precio" SortExpression="Precio" />
                <asp:BoundField DataField="PrecioUnidad" HeaderText="PrecioUnidad" SortExpression="PrecioUnidad" />
                <asp:BoundField DataField="nomMarcas" HeaderText="nomMarcas" SortExpression="nomMarcas" />
            </Columns>
            <EditRowStyle BackColor="#999999" />
            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
            <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
            <SortedAscendingCellStyle BackColor="#E9E7E2" />
            <SortedAscendingHeaderStyle BackColor="#506C8C" />
            <SortedDescendingCellStyle BackColor="#FFFDF8" />
            <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
        </asp:GridView>
        <asp:ObjectDataSource ID="ObjectDataSource4" runat="server" SelectMethod="GetComponentes" TypeName="ExamenEduardo.App_Code.ComponenteData"></asp:ObjectDataSource>
        <asp:GridView ID="GridView3" runat="server" AutoGenerateColumns="False" CellPadding="4" DataSourceID="ObjectDataSource3" ForeColor="#333333" GridLines="None">
            <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
            <Columns>
                <asp:BoundField DataField="ProductoId" HeaderText="ProductoId" SortExpression="ProductoId" />
                <asp:BoundField DataField="ProdcutoNombre" HeaderText="ProdcutoNombre" SortExpression="ProdcutoNombre" />
                <asp:BoundField DataField="ProductoPrecio" HeaderText="ProductoPrecio" SortExpression="ProductoPrecio" />
                <asp:TemplateField HeaderText="Sus componentes">
                    <ItemTemplate>
                        <asp:GridView ID="GridView4" runat="server" CellPadding="4" DataSource='<%# Eval("Componentes") %>' ForeColor="#333333" GridLines="None">
                            <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
                            <EditRowStyle BackColor="#999999" />
                            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                            <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
                            <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
                            <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
                            <SortedAscendingCellStyle BackColor="#E9E7E2" />
                            <SortedAscendingHeaderStyle BackColor="#506C8C" />
                            <SortedDescendingCellStyle BackColor="#FFFDF8" />
                            <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
                        </asp:GridView>
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
            <EditRowStyle BackColor="#999999" />
            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
            <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
            <SortedAscendingCellStyle BackColor="#E9E7E2" />
            <SortedAscendingHeaderStyle BackColor="#506C8C" />
            <SortedDescendingCellStyle BackColor="#FFFDF8" />
            <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
        </asp:GridView>
        <asp:ObjectDataSource ID="ObjectDataSource3" runat="server" SelectMethod="GetProducts" TypeName="ExamenEduardo.ExamenRepositorio"></asp:ObjectDataSource>
        <asp:DropDownList ID="DropDownList1" runat="server" DataSourceID="ObjectDataSource5" DataTextField="ProdcutoNombre" DataValueField="ProductoId" style="height: 25px">
        </asp:DropDownList>
        <asp:DropDownList ID="DropDownList2" runat="server" DataSourceID="ObjectDataSource6" DataTextField="ComponenteNombre" DataValueField="ComponenteId">
        </asp:DropDownList>
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Insertar relacion" />
        <asp:ObjectDataSource ID="ObjectDataSource5" runat="server" SelectMethod="GetProducts" TypeName="ExamenEduardo.ExamenRepositorio"></asp:ObjectDataSource>
        <asp:ObjectDataSource ID="ObjectDataSource6" runat="server" SelectMethod="GetComponents" TypeName="ExamenEduardo.ExamenRepositorio"></asp:ObjectDataSource>
    </form>
</body>
</html>
