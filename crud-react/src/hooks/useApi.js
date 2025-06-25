import { useState, useEffect } from 'react';
import axios from 'axios';

export default function useApi(baseUrl) { // para interactuar con las apis para realizar las solicitdues http
  const [data, setData] = useState([]);

  const fetchAll = async () => {
    const res = await axios.get(`${baseUrl}/lista`);
    setData(res.data);
  };

  const create = async (item) => {
    await axios.post(`${baseUrl}/guardar`, item);
    fetchAll();
  };

  const update = async (id, item) => {
    await axios.put(`${baseUrl}/actualizar/${id}`, item);
    fetchAll();
  };

  const remove = async (id) => {
    await axios.delete(`${baseUrl}/${id}`);
    fetchAll();
  };

  useEffect(() => { fetchAll(); }, []);

  return { data, create, update, remove };
}