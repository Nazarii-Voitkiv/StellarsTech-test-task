import { useEffect, useState } from 'react';
import type {Note} from '../../types/Note';
import { getNotes, createNote, updateNote, deleteNote } from '../../api/notes';
import NoteForm from '../../components/NoteForm/NoteForm';
import FilterBar from '../../components/FilterBar/FilterBar';
import NotesList from '../../components/NotesList/NotesList';
import styles from './HomePage.module.css';
import { FiFileText } from 'react-icons/fi';

export default function HomePage() {
    const [notes, setNotes] = useState<Note[]>([]);
    const [searchTitle, setSearchTitle] = useState('');
    const [fromDate, setFromDate] = useState('');
    const [toDate, setToDate] = useState('');
    const [editingNote, setEditingNote] = useState<Note | null>(null);

    const fetchNotes = async () => {
        const res = await getNotes({
            title: searchTitle || undefined,
            from: fromDate || undefined,
            to: toDate || undefined,
        });
        setNotes(res.data);
    };

    useEffect(() => {
        fetchNotes();
    }, [searchTitle, fromDate, toDate]);

    const handleSave = async (data: { title: string; content: string }, id?: string) => {
        if (id) {
            await updateNote(id, data);
            setEditingNote(null);
        } else {
            await createNote(data);
        }
        fetchNotes();
    };

    const handleDelete = async (id: string) => {
        await deleteNote(id);
        fetchNotes();
    };

    return (
        <div className={styles.container}>
            <h1>
                <FiFileText style={{ marginRight: 8 }} />
                Система нотаток
            </h1>
            <NoteForm onSave={handleSave} editingNote={editingNote} onCancelEdit={() => setEditingNote(null)} />
            <FilterBar
                title={searchTitle}
                from={fromDate}
                to={toDate}
                setTitle={setSearchTitle}
                setFrom={setFromDate}
                setTo={setToDate}
            />
            <NotesList notes={notes} onDelete={handleDelete} onEdit={setEditingNote} />
        </div>
    );
}