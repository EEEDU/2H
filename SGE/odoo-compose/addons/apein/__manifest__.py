# -*- coding: utf-8 -*-
{
    'name': "Apein",

    'summary': """
        Gestion de una empresa llamada apein
    """,

    'description': """
        Este es un modulo de prueba para el examen
    """,

    'author': "edu",
    'website': "http://www.salesianos.edu",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/master/openerp/addons/base/module/module_data.xml
    # for the full list
    'category': 'Uncategorized',
    'version': '0.1',

    # any module necessary for this one to work correctly
    'depends': ['base'],

    # always loaded
    'data': [
        'views.xml',
    ],

    # Indicamos que es una aplicacion
    'application': True,
}
