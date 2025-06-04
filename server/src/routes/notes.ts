import { Router, Request, Response, Handler } from 'express';
import { v4 as uuidv4 } from 'uuid';
import { readNotes, writeNotes } from '../utils/fs';
import { Note } from '../models/note';

const router = Router();

// Типи для запитів
type NoteParams = { id: string };
type NoteBody = { title: string; content: string };

router.get('/', (req: Request, res: Response<Note[]>) => {
    const { title, from, to } = req.query;

    let notes = readNotes();

    // 🔍 Пошук за заголовком
    if (typeof title === 'string' && title.trim() !== '') {
        notes = notes.filter(note =>
            note.title.toLowerCase().includes(title.toLowerCase())
        );
    }

    // 📅 Фільтрація за датою
    if (typeof from === 'string') {
        const fromDate = new Date(from);
        notes = notes.filter(note => new Date(note.createdAt) >= fromDate);
    }

    if (typeof to === 'string') {
        const toDate = new Date(to);
        notes = notes.filter(note => new Date(note.createdAt) <= toDate);
    }

    res.json(notes);
});

// POST /notes — створити нотатку
router.post('/', (req: Request<{}, {}, NoteBody>, res: Response<Note>) => {
    const { title, content } = req.body;
    const newNote: Note = {
        id: uuidv4(),
        title,
        content,
        createdAt: new Date().toISOString(),
        updatedAt: new Date().toISOString(),
    };

    const notes = readNotes();
    notes.push(newNote);
    writeNotes(notes);

    res.status(201).json(newNote);
});

router.put('/:id', ((req, res) => {
    const { id } = req.params;
    const { title, content } = req.body;

    const notes = readNotes();
    const index = notes.findIndex((note) => note.id === id);
    if (index === -1) {
        return res.status(404).json({ error: 'Note not found' });
    }

    notes[index] = {
        ...notes[index],
        title,
        content,
        updatedAt: new Date().toISOString(),
    };

    writeNotes(notes);
    res.json(notes[index]);
}) as Handler);

router.delete('/:id', ((req, res) => {
    const { id } = req.params;

    const notes = readNotes();
    const filtered = notes.filter((note) => note.id !== id);

    if (filtered.length === notes.length) {
        return res.status(404).json({ error: 'Note not found' });
    }

    writeNotes(filtered);
    res.status(204).send();
}) as Handler);

export default router;