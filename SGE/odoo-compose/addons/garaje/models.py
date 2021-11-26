# -*- coding: utf-8 -*-
from odoo import models, fields, api
from dateutil.relativedelta import *
from datetime import date


class aparcamiento(models.Model):
    _name = 'garaje.aparcamiento'
    _description = 'Permite definir las caracteristicas de un aparcamiento'

    name = fields.Char(string='Dirección', required=True)
    plazas = fields.Integer(string='Plazas', required=True)

    # relacion entre tablas
    coche_ids = fields.One2many(
        'garaje.coche', 'aparcamiento_id', string='Coches')


class coche(models.Model):
    _name = 'garaje.coche'
    _description = 'Permite definir las caracteristicas de un coche'
    _order = 'name'

    name = fields.Char(string='Matrícula', required=True, size=7)
    modelo = fields.Char(string='Modelo', requierd=True)
    construido = fields.Date(string='Fecha de construcción')
    consumo = fields.Float(string='Consumo', default=0.0,
                           help='Consumo promedio cada 100 kilometros')
    averiado = fields.Boolean(string='Averiado', default=False)
    # store=True para recalcularlo dependiendo de api.depends pero no se hace en este caso
    annos = fields.Integer(string='Años', compute='_get_annos')
    descripcion = fields.Text(string='Descripcion')

    aparcamiento_id = fields.Many2one(
        'garaje.aparcamiento', string='Aparcamiento', required=True)
    mantenimiento_ids = fields.Many2many(
        'garaje.mantenimiento', string='Mantenimientos')

    @api.depends('construido')
    def _get_annos(self):
        for coche in self:
            hoy = date.today()
            coche.annos = relativedelta(hoy, coche.construido).years
    # restriccion, mismo formato que en la bad
    _sql_constraints = [
        ('name_uniq', 'unique(name)', 'La matricula ya existe')]


class mantenimiento(models.Model):
    _name = 'garaje.mantenimiento'
    _description = 'Permite definir mantenimientos sobre conjuntos de coches'
    _order = 'fecha'

    fecha = fields.Char(string='Fecha', required=True,
                        default=fields.date.today())
    tipo = fields.Selection(string='Tipo', selection=[(
        'l', 'Lavar'), ('r', 'Revision'), ('m', 'Mecanica'), ('p', 'Pintura')], default='l')
    coste = fields.Float(
        string='Coste', help='Coste total del mantenimiento')

    coche_ids = fields.Many2many('garaje.coche', string='Coches')

    def get_name(self):
        resultados = []
        for mantenimiento in self:
            descripcion = f'{len(mantenimiento.coche_ids)} coche - {mantenimiento.coste} €'
            resultados.append((mantenimiento.id, descripcion))
        return resultados
