import fs from 'fs';
import { Note } from '../models/note';

const FILE_PATH = 'notes.json';

export function readNotes(): Note[] {
    try {
        const data = fs.readFileSync(FILE_PATH, 'utf-8');
        return JSON.parse(data);
    } catch {
        return [];
    }
}

export function writeNotes(notes: Note[]): void {
    fs.writeFileSync(FILE_PATH, JSON.stringify(notes, null, 2));
}