import axios from 'axios';
import type {Note} from '../types/Note';

const API = axios.create({
    baseURL: 'http://localhost:3001',
});

export const getNotes = (params?: { title?: string; from?: string; to?: string }) =>
    API.get<Note[]>('/notes', { params });

export const createNote = (data: { title: string; content: string }) =>
    API.post<Note>('/notes', data);

export const updateNote = (id: string, data: { title: string; content: string }) =>
    API.put<Note>(`/notes/${id}`, data);

export const deleteNote = (id: string) =>
    API.delete(`/notes/${id}`);