# -*- coding: utf-8 -*-
from odoo import models, fields, api
from dateutil.relativedelta import *
from datetime import date


class ejercicio1(models.Model):
    _name = 'B2R5EduardoGuerrero.ejercicio1'

    name = fields.Char(string='Nombre', required=True)
    numero1 = fields.Integer(string='Numero 1', required=True)
    numero2 = fields.Integer(string='Numero 2', required=True)
    numero3 = fields.Integer(string='Numero 3', required=True)
    media = fields.Integer(string='Media', compute='_get_media')

    @api.depends('numero1', 'numero2', 'numero3')
    def _get_media(self):
        for ejercicio1 in self:
            ejercicio1.media = (ejercicio1.numero1 +
                                ejercicio1.numero2 + ejercicio1.numero3) / 3


class ejercicio2(models.Model):
    _inherit = 'B2R5EduardoGuerrero.ejercicio1'
    _name = 'B2R5EduardoGuerrero.ejercicio2'

    numero4 = fields.Integer(string='Numero 4', required=True)
