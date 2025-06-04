import { useState, useEffect } from 'react';
import styles from './NoteForm.module.css';
import type {Note} from '../../types/Note';
import { FiSave, FiPlus, FiX } from 'react-icons/fi';

interface Props {
    onSave: (data: { title: string; content: string }, id?: string) => void;
    editingNote?: Note | null;
    onCancelEdit: () => void;
}

export default function NoteForm({ onSave, editingNote, onCancelEdit }: Props) {
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');

    useEffect(() => {
        if (editingNote) {
            setTitle(editingNote.title);
            setContent(editingNote.content);
        } else {
            setTitle('');
            setContent('');
        }
    }, [editingNote]);

    const handleSubmit = () => {
        if (!title.trim()) {
            alert('Поле "Заголовок" не може бути порожнім.');
            return;
        }

        if (!content.trim()) {
            alert('Поле "Зміст" не може бути порожнім.');
            return;
        }

        if (title.length > 100) {
            alert('Заголовок не повинен перевищувати 100 символів.');
            return;
        }

        onSave({ title, content }, editingNote?.id);
        setTitle('');
        setContent('');
    };

    return (
        <div className={styles.form}>
            <input
                type="text"
                placeholder="Заголовок"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                className={styles.input}
            />
            <textarea
                placeholder="Зміст"
                value={content}
                onChange={(e) => setContent(e.target.value)}
                className={styles.textarea}
            />
            <div className={styles.actions}>
                <button onClick={handleSubmit} className={styles.save}>
                    {editingNote ? (
                        <>
                            <FiSave /> <span>Оновити</span>
                        </>
                    ) : (
                        <>
                            <FiPlus /> <span>Додати</span>
                        </>
                    )}
                </button>
                {editingNote && (
                    <button onClick={onCancelEdit} className={styles.cancel}>
                        <FiX /> <span>Скасувати</span>
                    </button>
                )}
            </div>
        </div>
    );
}