from odoo import fields, models, api
from odoo.exceptions import ValidationError

class Curso(models.Model):
    _name = 'aca.curso'
    name = fields.Char('Name')
    description = fields.Text('Description')
    sesion_id = fields.One2many('aca.sesions', 'Curso_id', string='sesion')

    @api.constrains('name', 'description')
    def _check_something(self):
        for record in self:
            if record.name == record.description:
                raise ValidationError("The name must be different than description")

class Sesion(models.Model):
    _name = 'aca.sesions'
    name = fields.Char('Name')
    start_date = fields.Date('Start Date', default=fields.Date.today())
    active = fields.Boolean('Active', default=True)
    duration = fields.Integer('Duration', default=1)
    seats_available = fields.Integer('Seats')
    percentage_seats = fields.Float('Percentage seats', compute='_compute_percentage')
    Curso_id = fields.Many2one('aca.curso', string='Curso')
    usuario_id = fields.Many2one('aca.usuarios', string='Responsable usuario')
    companeros_ids = fields.Many2many('aca.companeross', 'sesion_companeros_pk', 'companeross_id', 'sesions_id', string='Asistentes')

    @api.depends('seats_available', 'companeros_ids')
    def _compute_percentage(self):
        for record in self:

            if len(record.companeros_ids) <= 0 or record.seats_available <= 0:
                record.percentage_seats = 0.0
            else:
                record.percentage_seats = len(record.companeros_ids) / record.seats_available * 100


    @api.onchange('duration')
    def _onchange_duration(self):
        if self.duration <= 0 :
            return {
                'warning': {
                    'title': "Duration",
                    'message': "The duration is invalid",
                }
        }
    
    @api.onchange('seats_available')
    def _onchange_seats_available(self):
        if self.seats_available <= 0 :
            return {
                'warning': {
                    'title': "Seats Available",
                    'message': "The number of seats is invalid",
                }
        }

class Usuario(models.Model):
    _name = 'aca.usuarios'
    name = fields.Char('Name')
    sesion_id = fields.One2many('aca.sesions', 'usuario_id', string='sesion')


class Companeros(models.Model):
    _name = 'aca.companeross'
    name = fields.Char('Name')
    sesion_ids = fields.Many2many('aca.sesions', 'sesion_companeros_pk', 'sesions_id', 'companeross_id', string='Sesiones')


class Instructor(models.Model):
    _inherit = 'aca.companeross'
    instructor = fields.Boolean('Instructor')
