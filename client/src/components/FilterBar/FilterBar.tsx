import styles from './FilterBar.module.css';

interface Props {
    title: string;
    from: string;
    to: string;
    setTitle: (val: string) => void;
    setFrom: (val: string) => void;
    setTo: (val: string) => void;
}

export default function FilterBar({title, from, to, setTitle, setFrom, setTo}: Props) {
    return (
        <div className={styles.bar}>
            <div style={{flex: 1, display: 'flex', alignItems: 'center', gap: 8}}>
                <input
                    type="text"
                    placeholder="Пошук за заголовком"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                />
            </div>

            <div style={{display: 'flex', alignItems: 'center', gap: 8}}>
                <input type="date" value={from} onChange={(e) => setFrom(e.target.value)}/>
            </div>

            <div style={{display: 'flex', alignItems: 'center', gap: 8}}>
                <input type="date" value={to} onChange={(e) => setTo(e.target.value)}/>
            </div>
        </div>
    );
}