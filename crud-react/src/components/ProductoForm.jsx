
import React, { useState, useEffect } from 'react';

export default function ProductoForm({ categorias, onSave, onUpdate, toEdit, clearEdit }) {
    const [form, setForm] = useState({ nombre: '', descripcion: '', categoriaId: '' });

    useEffect(() => {
        if (toEdit) {
            setForm({
                nombre: toEdit.nombre,
                descripcion: toEdit.descripcion,
                categoriaId: toEdit.categoria?.id || ''
            });
        }
    }, [toEdit]);

    const handleSubmit = (e) => {
        e.preventDefault();
        const categoria = categorias.find(c => c.id === parseInt(form.categoriaId));
        const payload = { ...form, categoria };
        if (toEdit) {
            onUpdate(toEdit.id, payload);
        } else {
            onSave(payload);
        }
        setForm({ nombre: '', descripcion: '', categoriaId: '' });
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
            <select
                value={form.categoriaId}
                onChange={e => setForm({ ...form, categoriaId: e.target.value })}
                className="border p-2 m-1"
            >
                <option value="">Selecciona Categoría</option>
                {categorias.map(c => (
                    <option key={c.id} value={c.id}>{c.nombre}</option>
                ))}
            </select>
            <button
                className={`p-2 ${toEdit ? 'update' : 'save'}`}
            >
                {toEdit ? 'Actualizar' : 'Guardar'}
            </button>
            {toEdit && (
                <button type="button" onClick={clearEdit} className="ml-2 cancel"> Cancelar </button>
            )}
        </form>
    );
}