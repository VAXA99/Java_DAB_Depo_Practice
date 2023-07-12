import React from 'react';
import styles from './Header.css'

const Header = () => {
    return (
        <header className="header">
            <div className="header-container">
                <div className="logo">
                    DabDepo
                </div>
                <nav className="nav">
                    <a href="/" className="nav-link">Главная</a>
                    <a href="/wagons" className="nav-link">Вагоны</a>
                </nav>
            </div>
        </header>
    );
}

export default Header;
