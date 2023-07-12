import React, { useState, useEffect } from 'react';
import styles from './WagonList.css';
import Header from '../Header/Header';
import {backend} from "../../backend";
import {Link} from "react-router-dom";

const WagonList = () => {
    const [wagons, setWagons] = useState([]);

    useEffect(() => {
        const fetchWagons = async () => {
            try {
                const data = await backend.getWagons();
                setWagons(data);
            } catch (error) {
                console.error('Error fetching wagons:', error);
            }
        };

        fetchWagons();
    }, []);

    const handleDelete = async (id) => {
        try {
            await backend.deleteWagon(id);
            setWagons((prevWagons) => prevWagons.filter((wagon) => wagon.id !== id));
        } catch (error) {
            console.error(`Error deleting wagon with ID ${id}:`, error);
        }
    };

    const handleUpdate = (id) => {
        // Handle update logic, e.g., navigate to the edit page or show a modal
        console.log(`Update wagon with ID ${id}`);
    };

    return (
        <>
            <Header />
            <table className="wagons-table">
                <thead>
                <tr>
                    <th className="table-header">ID</th>
                    <th className="table-header">Тип</th>
                    <th className="table-header">Процент загрузки</th>
                    <th className="table-header">Серийный номер</th>
                    <th className="table-header">Станция приписки</th>
                    <th className="table-header">Грузопододъемность</th>
                    <th className="table-header">Год выпуска</th>
                    <th className="table-header">Действия</th>
                </tr>
                </thead>
                <tbody>
                {wagons.map((wagon) => (
                    <tr key={wagon.id} className="wagon-row">
                        <td className="table-data">{wagon.id}</td>
                        <td className="table-data">{wagon.wagonType}</td>
                        <td className="table-data">{wagon.loadingPercentage}</td>
                        <td className="table-data">{wagon.serialNumber}</td>
                        <td className="table-data">{wagon.homeStation}</td>
                        <td className="table-data">{wagon.loadCapacity}</td>
                        <td className="table-data">{wagon.yearOfRelease}</td>
                        <td className="table-change">
                            <button onClick={() => handleUpdate(wagon.id)}>✏️</button>
                            <button onClick={() => handleDelete(wagon.id)}>❌</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </>
    );
};

export default WagonList;
