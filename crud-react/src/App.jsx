import React, { useState } from 'react';
import CategoriaForm from './components/CategoriaForm';
import CategoriaList from './components/CategoriaList';
import ProductoForm from './components/ProductoForm';
import ProductoList from './components/ProductoList';
import useApi from './hooks/useApi';

export default function App() {
  const categoriaApi = useApi('http://localhost:8080/api/categorias');
  const productoApi = useApi('http://localhost:8080/api/producto');

  const [categoriaEdit, setCategoriaEdit] = useState(null);
  const [productoEdit, setProductoEdit] = useState(null);

  return (
    <div className="p-6">
      <h1 className="text-xl font-bold">CRUD Categorías</h1>
      <CategoriaForm
        onSave={categoriaApi.create}
        onUpdate={categoriaApi.update}
        toEdit={categoriaEdit}
        clearEdit={() => setCategoriaEdit(null)}
      />
      <CategoriaList
        categorias={categoriaApi.data} //recibe la rpta del backend en una data
        onDelete={categoriaApi.remove}
        onEdit={setCategoriaEdit}
      />

      <h1 className="text-xl font-bold mt-6">CRUD Productos</h1>
      <ProductoForm
        categorias={categoriaApi.data}
        onSave={productoApi.create}
        onUpdate={productoApi.update}
        toEdit={productoEdit}
        clearEdit={() => setProductoEdit(null)}
      />
      <ProductoList
        productos={productoApi.data}e
        onDelete={productoApi.remove}
        onEdit={setProductoEdit}
      />
    </div>
  );
}
