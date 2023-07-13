import React, {useState, useEffect} from 'react';
import styles from './AddWagonForm.css';
import Header from '../Header/Header';
import {backend} from "../../backend";

const AddWagonForm = () => {
    const handleSubmit = async (event) => {
        event.preventDefault();
        const form = event.target;
        const wagon = {
            wagonType: form.wagonType.value,
            loadingPercentage: parseInt(form.loadingPercentage.value),
            serialNumber: parseInt(form.serialNumber.value),
            homeStation: form.homeStation.value,
            loadCapacity: parseInt(form.loadCapacity.value),
            yearOfRelease: parseInt(form.yearOfRelease.value),
        };

        try {
            await backend.addWagon(wagon);
            window.location.href = '/wagons';
        } catch (error) {
            console.error('Error adding wagon:', error);
        }
    };



    return (
        <>
            <Header/>
            <form className="edit-wagon-form" onSubmit={handleSubmit}>
                <table className="wagons-table">
                    <thead>
                    <tr>
                        <th className="table-header">Тип</th>
                        <th className="table-header">Процент загрузки</th>
                        <th className="table-header">Серийный номер</th>
                        <th className="table-header">Станция приписки</th>
                        <th className="table-header">Грузоподъемность</th>
                        <th className="table-header">Год выпуска</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td className="table-data"><input type="text" name="wagonType" required/></td>
                        <td className="table-data"><input type="number" name="loadingPercentage" required/></td>
                        <td className="table-data"><input type="number" name="serialNumber" required/></td>
                        <td className="table-data"><input type="text" name="homeStation" required/></td>
                        <td className="table-data"><input type="number" name="loadCapacity" required/></td>
                        <td className="table-data"><input type="number" name="yearOfRelease" required/></td>
                        <td className="table-change">
                            <button type="submit">Добавить</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </>
    );
};

export default AddWagonForm;















