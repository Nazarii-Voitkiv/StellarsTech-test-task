import express from 'express';
import cors from 'cors';
import notesRoutes from './routes/notes';

const app = express();
const PORT = 3001;

app.use(cors());
app.use(express.json());

app.use('/notes', notesRoutes);

app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});