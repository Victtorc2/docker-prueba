import React from 'react';

export default function ProductoList({ productos, onDelete, onEdit }) {
  return (
    <ul>
      {productos.map(p => (
        <li key={p.id} className="mb-2">
          <b>{p.nombre}</b>: {p.descripcion} <i>({p.categoria?.nombre})</i>
          <button onClick={() => onEdit(p)} className="ml-2 text-blue-600">Editar</button>
          <button onClick={() => onDelete(p.id)} className="ml-2 text-red-600">Eliminar</button>
        </li>
      ))}
    </ul>
  );
}
