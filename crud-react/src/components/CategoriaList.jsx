import React from 'react';

export default function CategoriaList({ categorias, onDelete, onEdit }) {
  return (
    <ul>
      {categorias.map(c => (
        <li key={c.id} className="mb-2">
          <b>{c.nombre}</b>: {c.descripcion}
          <button onClick={() => onEdit(c)} className="ml-2 text-blue-600">Editar</button>
          <button onClick={() => onDelete(c.id)} className="ml-2 text-red-600">Eliminar</button>
        </li>
      ))}1
    </ul>
  );
}
