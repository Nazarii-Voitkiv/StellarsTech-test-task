import styles from './NotesList.module.css';
import NoteCard from '../NoteCard/NoteCard';
import type {Note} from '../../types/Note';

interface Props {
    notes: Note[];
    onDelete: (id: string) => void;
    onEdit: (note: Note) => void;
}

export default function NotesList({ notes, onDelete, onEdit }: Props) {
    return (
        <div className={styles.grid}>
            {notes.map((note) => (
                <NoteCard key={note.id} note={note} onDelete={onDelete} onEdit={onEdit} />
            ))}
        </div>
    );
}