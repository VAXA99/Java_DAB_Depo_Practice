import React from 'react';
import styles from './HomePage.css'
import Header from "../Header/Header";

const HomePage = () => {
    return (
        <>
            <Header />
            <div className="intro">
                <div className="container">
                    <div className="intro__inner">
                        <h1 className="intro__title">Добро пожаловать!</h1>
                        <h2 className="intro__subtitle">Здесь ты можешь отслеживать вагоны в режиме реального времени!</h2>
                        <a className="btn btn--red" href="/wagons">Отслеживать</a>
                    </div>
                </div>
            </div>
        </>
    );
}

export default HomePage;