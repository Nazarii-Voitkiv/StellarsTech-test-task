import styles from './NoteCard.module.css';
import type {Note} from '../../types/Note';
import {FiEdit2, FiTrash2} from 'react-icons/fi';
import { formatDate } from '../../utils/formatDate';

interface Props {
    note: Note;
    onDelete: (id: string) => void;
    onEdit: (note: Note) => void;
}

export default function NoteCard({note, onDelete, onEdit}: Props) {
    return (
        <div className={styles.card}>
            <div className={styles.header}>
                <h2>{note.title}</h2>
                <div className={styles.actions}>
                    <button onClick={() => onEdit(note)}><FiEdit2/>️</button>
                    <button onClick={() => onDelete(note.id)}><FiTrash2/></button>
                </div>
            </div>
            <p className={styles.content}>{note.content}</p>
            <div className={styles.meta}>
                {formatDate(note.createdAt)}
            </div>
        </div>
    );
}