# -*- coding: utf-8 -*-
from odoo import models, fields, api, exceptions
from dateutil.relativedelta import *
from datetime import date


class proveedor(models.Model):
    _name = 'apein.proveedor'
    _descripcion = 'El proveedor de los componentes'

    name = fields.Integer(string='codProveedor', required=True, unique=True)
    nomProveedor = fields.Char(string='Nombre', required=True)

    componente_ids = fields.Many2many('apein.componente', string='Componentes')
    pedidoProveedor_ids = fields.One2many(
        'apein.pedidoproveedor', 'proveedor_id', string='PedidosProveedores')
    # TODO _sql_constrain
    _sql_constraints = [('name_uniq', 'unique(name)',
                         'El codProveedor ya existe')]

    @api.constrains('nomProveedor')
    def _check_name(self):
        for proveedor in self:
            if proveedor.nomProveedor == "proveedor":
                raise exceptions.ValidationError("Error")


class componente(models.Model):
    _name = 'apein.componente'
    _descripcion = 'El comopnenete de nuestro prodcuto'

    name = fields.Integer(string='codComponente', required=True)
    nomComponente = fields.Char(string='Nombre', required=True)

    proveedor_ids = fields.Many2many('apein.proveedor', string='Proveedores')
    pedidoProveedor_ids = fields.Many2many(
        'apein.pedidoproveedor', string='PedidosProveedores')
    marca_id = fields.Many2one('apein.marca', string='Marca')


class pedidoProveedor(models.Model):
    _name = 'apein.pedidoproveedor'
    _description = 'Pedidos que nos puede hacer un proveedor'

    name = fields.Integer(string='numPedido', required=True)
    fecha = fields.Date(string='fecha', default=fields.date.today())

    proveedor_id = fields.Many2one('apein.proveedor', string='Proveedor')
    componente_ids = fields.Many2one('apein.componente', string='Componentes')


class marca(models.Model):
    _name = 'apein.marca'
    _description = 'Un componente tiene una marca'

    name = fields.Integer(string='codMarca', required=True)
    nomMarca = fields.Char(string='Nombre', required=True)
    fecha = fields.Date(string='Fecha', required=True)
    annos = fields.Integer(string='Años', compute='_get_annos')

    componente_ids = fields.One2many(
        'apein.componente', 'marca_id', string='Componentes')

    @api.depends('fecha')
    def _get_annos(self):
        for marca in self:
            hoy = date.today()
            marca.annos = relativedelta(hoy, marca.fecha).years

    # @api.onchange('fecha')
    # def _get_annos(self):
    #     hoy = date.today()
    #     marca.annos = relativedelta(hoy, marca.fecha).years
