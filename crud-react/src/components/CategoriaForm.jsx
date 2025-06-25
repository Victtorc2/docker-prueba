import React, { useState, useEffect } from 'react';

export default function CategoriaForm({ onSave, onUpdate, toEdit, clearEdit }) { //recibir 4 props
    const [form, setForm] = useState({ nombre: '', descripcion: '' });

    useEffect(() => {
        if (toEdit) setForm(toEdit);
    }, [toEdit]);

    const handleSubmit = (e) => { // se ejecuta cuando el formulario es enviado.
        e.preventDefault();
        if (toEdit) {
            onUpdate(toEdit.id, form);
        } else {
            onSave(form);
        }
        setForm({ nombre: '', descripcion: '' }); //Después de guardar o actualizar, se limpia el formulario con 
        clearEdit();
    };

    return (
        <form onSubmit={handleSubmit} className="mb-4">
            <input
                type="text"
                placeholder="Nombre"
                value={form.nombre}
                onChange={e => setForm({ ...form, nombre: e.target.value })}
                className="border p-2 m-1"
            />
            <input
                type="text"
                placeholder="Descripción"
                value={form.descripcion}
                onChange={e => setForm({ ...form, descripcion: e.target.value })}
                className="border p-2 m-1"
            />
            <button
                className={`p-2 ${toEdit ? 'update' : 'save'}`}
            >
                {toEdit ? 'Actualizar' : 'Guardar'}
            </button>

            {toEdit && (
                <button
                    type="button"
                    onClick={clearEdit}
                    className="ml-2 cancel"
                >
                    Cancelar
                </button>
            )}
        </form>
    );
}