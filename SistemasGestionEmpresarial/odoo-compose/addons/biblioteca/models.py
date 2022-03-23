# -*- coding: utf-8 -*-
from odoo import models, fields, api


class libro(models.Model):
    _name = 'biblioteca.libro'
    _description = 'Permite definir las caracteristicas de un libro'
    _order = 'fecha'

    name = fields.Char(string='Titulo', required=True)
    autor = fields.Char(string='Autor', required=True)
    fecha = fields.Date(string='Fecha', default=fields.Date.today())
    pelicula = fields.Boolean(string='Pelicula', default=False)

    # Relacion entre tablas
    autor_id = fields.Many2one('biblioteca.autor', string='Autor')


class autor(models.Model):
    _name = 'biblioteca.autor'
    _description = 'Permite definir las caracteristicas de un autor'

    name = fields.Char(string='Nombre', required=True)
    apellidos = fields.Char(string='Apellidos', required=True)
    fechaNac = fields.Date(string='Fecha Nacimiento')
    fechaDef = fields.Date(string='Fecha Muerte')

    # Relacion entre tablas
    libro_ids = fields.One2many('biblioteca.libro', 'autor_id', string='Autor')
    pais_id = fields.Many2One('biblioteca.pais', string='Autor')


class premio(models.Model):
    _name = 'biblioteca.premio'
    _description = 'Permite definir las caracteristicas de un premio'

    name = fields.Char(string='Nombre', required=True)
    categoria = fields.Selection(string='Categoria', selection=[(
        'n', 'Nacional'), ('i', 'Internacional'), ('l', 'local')], default='n')


class pais(models.Model):
    _name = 'biblioteca.pais'
    _description = 'Permite definir las caracteristicas de un pais'

    name = fields.Char(string='Nombre', required=True)
    continente = fields.Char(string='Continente')
