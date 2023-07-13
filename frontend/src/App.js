import React from 'react';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import HomePage from './components/HomePage/HomePage';
import WagonList from './components/WagonList/WagonList';
import AddWagonForm from './components/AddWagonForm/AddWagonForm';
import EditWagonForm from "./components/EditWagonFrom/EditWagonForm";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/wagons" element={<WagonList />} />
                <Route path="/add" element={<AddWagonForm />} />
                <Route path="/edit/:id" element={<EditWagonForm />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
