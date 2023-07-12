import React from 'react';
import styles from './AddWagonForm.css';
import Header from "../Header/Header";

const AddWagonForm = () => {
    return (
        <>
            <Header/>
            <form className="edit-wagon-form" action="/add" method="post">
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
}

export default AddWagonForm;
